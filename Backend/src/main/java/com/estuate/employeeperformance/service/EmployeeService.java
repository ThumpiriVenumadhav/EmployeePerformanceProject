package com.estuate.employeeperformance.service;

import com.estuate.employeeperformance.entity.Employee;
import com.estuate.employeeperformance.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    
    Employee employee;

    @Cacheable(value = "employees")
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Cacheable(value = "employees")
    public Employee getEmployeeById(int id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        return employee.orElse(null);
    }

    @CacheEvict(value = "employees" , allEntries = true)
    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }
    
    
    public Employee updateEmployee(int id, Employee employeeDetails) {
        employee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));

        employee.setEmployeeName(employeeDetails.getEmployeeName());
        return employeeRepository.save(employee);
    }

    @CacheEvict(value = "employees" , allEntries = true)
    public void deleteEmployee(int id) {
    	
    	 employee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));
    	
        employeeRepository.deleteById(id);
    }
}
