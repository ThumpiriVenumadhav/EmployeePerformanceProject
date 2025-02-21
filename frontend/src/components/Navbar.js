import React from "react";
import { Navbar, Nav, Container } from "react-bootstrap";

const CustomNavbar = () => {
  return (
    <Navbar expand="lg" className="navbar">
      <Container>
        <Navbar.Brand href="/">Employee Dashboard</Navbar.Brand>
        <Navbar.Toggle aria-controls="basic-navbar-nav" />
        <Navbar.Collapse id="basic-navbar-nav">
          <Nav className="ms-auto">
            <Nav.Link href="/">Home</Nav.Link>
            <Nav.Link href="/employees">Employees</Nav.Link>
            <Nav.Link href="/profile">Profile</Nav.Link>
          </Nav>
        </Navbar.Collapse>
      </Container>
    </Navbar>
  );
};

export default CustomNavbar;
