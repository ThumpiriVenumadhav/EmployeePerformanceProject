import React, { useState } from "react";
import axios from "axios";
import { Form, Button, Container, Card, Row, Col } from "react-bootstrap";

const AddEmployee = () => {
    const [employee, setEmployee] = useState({
        employeeName: "",
        rating: "",
    });

    const handleChange = (e) => {
        setEmployee({ ...employee, [e.target.name]: e.target.value });
    };

    const handleSubmit = async (event) => {
        event.preventDefault();
        try {
            // Insert Employee and get the generated employee_id
            const employeeResponse = await axios.post("http://localhost:8080/employees", {
                employeeName: employee.employeeName,
            });

            const employeeId = employeeResponse.data.employeeId; // Get generated employee ID

            // Insert Rating into the Appraisal Table
            await axios.post("http://localhost:8080/appraisals", {
                employeeId: employeeId, 
                rating: employee.rating,
            });

            alert("Employee and Appraisal added successfully!");
            setEmployee({ employeeName: "", rating: "" }); // Reset form fields
        } catch (error) {
            console.error("Error adding employee or appraisal:", error);
        }
    };

    return (
        <Container className="mt-4">
            <Row className="justify-content-center">
                <Col md={6}>
                    <Card className="p-4 shadow">
                        <h2 className="text-center">Add Employee</h2>
                        <Form onSubmit={handleSubmit}>
                            <Form.Group className="mb-3">
                                <Form.Label>Employee Name</Form.Label>
                                <Form.Control
                                    type="text"
                                    name="employeeName"
                                    value={employee.employeeName}
                                    onChange={handleChange}
                                    placeholder="Enter employee name"
                                    required
                                />
                            </Form.Group>

                            <Form.Group className="mb-3">
                                <Form.Label>Rating (A-E)</Form.Label>
                                <Form.Select name="rating" value={employee.rating} onChange={handleChange} required>
                                    <option value="">Select Rating</option>
                                    <option value="A">A - Excellent</option>
                                    <option value="B">B - Good</option>
                                    <option value="C">C - Average</option>
                                    <option value="D">D - Below Average</option>
                                    <option value="E">E - Poor</option>
                                </Form.Select>
                            </Form.Group>

                            <Button type="submit" className="w-100">Add Employee</Button>
                        </Form>
                    </Card>
                </Col>
            </Row>
        </Container>
    );
};

export default AddEmployee;
