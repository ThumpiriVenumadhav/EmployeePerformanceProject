import React from "react";
import { BrowserRouter as Router, Routes, Route, Link } from "react-router-dom";
import EmployeeList from "./components/EmployeeList";
import AddEmployee from "./components/AddEmployee";
import PerformanceReport from "./components/PerformanceReport";
import BellCurveChart from "./components/BellCurveChart";
import { Navbar, Nav, Container } from "react-bootstrap";

function App() {
    return (
        <Router>
            <Navbar bg="dark" variant="dark" expand="lg">
                <Container>
                    <Navbar.Brand as={Link} to="/">Employee Performance</Navbar.Brand>
                    <Navbar.Toggle aria-controls="basic-navbar-nav" />
                    <Navbar.Collapse id="basic-navbar-nav">
                        <Nav className="ms-auto">
                            <Nav.Link as={Link} to="/">Employee List</Nav.Link>
                            <Nav.Link as={Link} to="/add">Add Employee</Nav.Link>
                            <Nav.Link as={Link} to="/report">Performance Report</Nav.Link>
                            <Nav.Link as={Link} to="/bellcurve">Bell Curve Analysis</Nav.Link>
                        </Nav>
                    </Navbar.Collapse>
                </Container>
            </Navbar>

            <Container className="mt-4">
                <Routes>
                    <Route path="/" element={<EmployeeList />} />
                    <Route path="/add" element={<AddEmployee />} />
                    <Route path="/report" element={<PerformanceReport />} />
                    <Route path="/bellcurve" element={<BellCurveChart />} />
                </Routes>
            </Container>
        </Router>
    );
}

export default App;
