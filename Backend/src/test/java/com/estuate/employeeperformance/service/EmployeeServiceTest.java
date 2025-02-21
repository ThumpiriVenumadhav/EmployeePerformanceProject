package com.estuate.employeeperformance.service;

import com.estuate.employeeperformance.entity.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional   // Ensures DB changes are rolled back after each test
class EmployeeServiceTest {

    @Autowired
    private EmployeeService employeeService;

    @Test
    void testAddEmployee() {
        Employee employee = new Employee();
        employee.setEmployeeId(100);
        employee.setEmployeeName("Test Employee");

        Employee savedEmployee = employeeService.addEmployee(employee);
        assertNotNull(savedEmployee);
        assertEquals("Test Employee", savedEmployee.getEmployeeName());
    }

    @Test
    void testGetAllEmployees() {
        List<Employee> employees = employeeService.getAllEmployees();
        assertNotNull(employees);
        assertTrue(employees.size() >= 0);
    }
}

