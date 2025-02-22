import React, { useEffect, useState } from "react";
import axios from "axios";
import { Table, Button, Container, Form } from "react-bootstrap";

const EmployeeList = () => {
    const [employees, setEmployees] = useState([]);
    const [editEmployee, setEditEmployee] = useState(null);
    const [updatedName, setUpdatedName] = useState("");
    const [updatedRating, setUpdatedRating] = useState("");

    useEffect(() => {
        fetchEmployees();
    }, []);

    const fetchEmployees = () => {
        axios.get("http://localhost:8080/employees")
            .then(response => {
                console.log("API Response:", response.data);
                setEmployees(response.data);
            })
            .catch(error => console.error("Error fetching employees:", error));
    };

    const handleEdit = (emp) => {
        setEditEmployee(emp.employeeId);
        setUpdatedName(emp.employeeName);
        setUpdatedRating(emp.appraisal ? emp.appraisal.rating : "Not Rated");
    };

    const handleUpdate = (id) => {
        const updates = {};
        
        if (updatedName !== "") updates.employeeName = updatedName;
        if (updatedRating !== "") updates.rating = updatedRating;
    
        axios.put(`http://localhost:8080/employees/${id}`, updates)
            .then((response) => {
                setEmployees(prevEmployees =>
                    prevEmployees.map(emp =>
                        emp.employeeId === id
                            ? { ...emp, ...updates, appraisal: { ...emp.appraisal, rating: updates.rating || emp.appraisal.rating } }
                            : emp
                    )
                );
                setEditEmployee(null);
            })
            .catch(error => console.error("Error updating employee:", error));
    };
    

    const handleDelete = (id) => {
        axios.delete(`http://localhost:8080/employees/${id}`)
            .then(() => fetchEmployees()) // Refresh list after delete
            .catch(error => console.error("Error deleting employee:", error));
    };

    return (
        <Container>
            <h2 className="text-center">Employee List</h2>
            <Table striped bordered hover responsive className="mt-3">
                <thead className="table-dark">
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Rating</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    {employees.length > 0 ? (
                        employees.map(emp => (
                            <tr key={emp.employeeId}>
                                <td>{emp.employeeId}</td>
                                <td>
                                    {editEmployee === emp.employeeId ? (
                                        <Form.Control
                                            type="text"
                                            value={updatedName}
                                            onChange={(e) => setUpdatedName(e.target.value)}
                                        />
                                    ) : (
                                        emp.employeeName
                                    )}
                                </td>
                                <td>
                                    {editEmployee === emp.employeeId ? (
                                        <Form.Control
                                            as="select"
                                            value={updatedRating}
                                            onChange={(e) => setUpdatedRating(e.target.value)}
                                        >
                                            <option value="A">A</option>
                                            <option value="B">B</option>
                                            <option value="C">C</option>
                                            <option value="D">D</option>
                                            <option value="E">E</option>
                                        </Form.Control>
                                    ) : (
                                        emp.appraisal ? emp.appraisal.rating : "Not Rated"
                                    )}
                                </td>
                                <td>
                                    {editEmployee === emp.employeeId ? (
                                        <>
                                            <Button variant="success" size="sm" onClick={() => handleUpdate(emp.employeeId)}>Save</Button>{' '}
                                            <Button variant="secondary" size="sm" onClick={() => setEditEmployee(null)}>Cancel</Button>
                                        </>
                                    ) : (
                                        <>
                                            <Button variant="warning" size="sm" onClick={() => handleEdit(emp)}>Edit</Button>{' '}
                                            <Button variant="danger" size="sm" onClick={() => handleDelete(emp.employeeId)}>Delete</Button>
                                        </>
                                    )}
                                </td>
                            </tr>
                        ))
                    ) : (
                        <tr>
                            <td colSpan="4" className="text-center">No employees found</td>
                        </tr>
                    )}
                </tbody>
            </Table>
        </Container>
    );
};

export default EmployeeList;
