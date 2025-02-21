import React, { useEffect, useState } from "react";
import axios from "axios";
import { Table, Button, Container, Form, Row, Col, Card } from "react-bootstrap";

const EmployeeList = () => {
    const [employees, setEmployees] = useState([]);
    const [editEmployee, setEditEmployee] = useState(null);
    const [updatedName, setUpdatedName] = useState("");

    useEffect(() => {
        fetchEmployees();
    }, []);

    const fetchEmployees = () => {
        axios.get("http://localhost:8080/employees")
            .then(response => setEmployees(response.data))
            .catch(error => console.error("Error fetching employees:", error));
    };

    const handleDelete = (id) => {
        axios.delete(`http://localhost:8080/employees/${id}`)
            .then(() => {
                setEmployees(employees.filter(emp => emp.employeeId !== id));
            })
            .catch(error => console.error("Error deleting employee:", error));
    };

    const handleUpdate = (id) => {
        axios.put(`http://localhost:8080/employees/${id}`, { employeeName: updatedName })
            .then(() => {
                setEmployees(employees.map(emp => 
                    emp.employeeId === id ? { ...emp, employeeName: updatedName } : emp
                ));
                setEditEmployee(null);
                setUpdatedName("");
            })
            .catch(error => console.error("Error updating employee:", error));
    };

    return (
        <Container className="mt-4">
            <Row className="justify-content-center">
                <Col md={10}>
                    <Card className="p-4 shadow">
                        <h2 className="text-center mb-4">Employee List</h2>
                        <div className="table-responsive">
                            <Table striped bordered hover responsive className="mt-3">
                                <thead className="table-dark">
                                    <tr>
                                        <th>ID</th>
                                        <th>Name</th>
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
                                                            placeholder="Enter new name"
                                                            className="edit-input"
                                                        />
                                                    ) : (
                                                        emp.employeeName
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
                                                            <Button variant="warning" size="sm" onClick={() => { setEditEmployee(emp.employeeId); setUpdatedName(emp.employeeName); }}>Edit</Button>{' '}
                                                            <Button variant="danger" size="sm" onClick={() => handleDelete(emp.employeeId)}>Delete</Button>
                                                        </>
                                                    )}
                                                </td>
                                            </tr>
                                        ))
                                    ) : (
                                        <tr>
                                            <td colSpan="3" className="text-center">No Employees Found</td>
                                        </tr>
                                    )}
                                </tbody>
                            </Table>
                        </div>
                    </Card>
                </Col>
            </Row>
        </Container>
    );
};

export default EmployeeList;
