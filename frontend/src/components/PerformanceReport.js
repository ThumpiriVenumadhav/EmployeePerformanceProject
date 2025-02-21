import React, { useEffect, useState } from "react";
import axios from "axios";
import { Container, Table, ProgressBar, Card, Spinner } from "react-bootstrap";

const PerformanceReport = () => {
    const [report, setReport] = useState(null);
    const [loading, setLoading] = useState(true);

    useEffect(() => {
        axios.get("http://localhost:8080/appraisals/report")
            .then(response => {
                setReport(response.data);
                setLoading(false);
            })
            .catch(error => {
                console.error("Error fetching report:", error);
                setLoading(false);
            });
    }, []);

    // Function to assign colors based on performance category
    const getProgressBarVariant = (category) => {
        switch (category) {
            case "High Performers": return "success";  // Green
            case "Average Performers": return "warning";  // Yellow
            case "Low Performers": return "danger";  // Red
            default: return "info";  // Blue for unknown categories
        }
    };

    return (
        <Container className="mt-4">
            <Card className="p-4 shadow-lg">
                <h2 className="text-center mb-4">Performance Report</h2>
                {loading ? (
                    <div className="text-center">
                        <Spinner animation="border" />
                        <p>Loading report...</p>
                    </div>
                ) : (
                    <Table bordered hover responsive className="mt-3">
                        <thead style={{ backgroundColor: "#343a40", color: "white" }}>
                            <tr>
                                <th>Category</th>
                                <th>Percentage</th>
                            </tr>
                        </thead>
                        <tbody>
                            {report ? (
                                Object.entries(report).map(([category, percentage]) => (
                                    <tr key={category}>
                                        <td>{category}</td>
                                        <td>
                                            <ProgressBar 
                                                now={parseFloat(percentage)} 
                                                variant={getProgressBarVariant(category)}
                                                style={{ height: "20px" }}
                                            />
                                        </td>
                                    </tr>
                                ))
                            ) : (
                                <tr>
                                    <td colSpan="2" className="text-center">No Data Available</td>
                                </tr>
                            )}
                        </tbody>
                    </Table>
                )}
            </Card>
        </Container>
    );
};

export default PerformanceReport;
