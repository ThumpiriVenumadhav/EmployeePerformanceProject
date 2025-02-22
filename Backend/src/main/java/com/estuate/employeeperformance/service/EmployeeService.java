package com.estuate.employeeperformance.service;

import com.estuate.employeeperformance.entity.Appraisal;
import com.estuate.employeeperformance.entity.Employee;
import com.estuate.employeeperformance.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    
    Employee employee;

    @Cacheable(value = "employees")
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAllWithAppraisal();
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
    
    
    public Employee updateEmployee(Integer id, Map<String, String> updates) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if (optionalEmployee.isPresent()) {
            Employee employee = optionalEmployee.get();

            // Update Name if provided
            if (updates.containsKey("employeeName")) {
                employee.setEmployeeName(updates.get("employeeName"));
            }

            // Update or Insert Rating in Appraisal
            if (updates.containsKey("rating")) {
                String newRating = updates.get("rating");
                if (employee.getAppraisal() == null) {
                    Appraisal newAppraisal = new Appraisal();
                    newAppraisal.setEmployee(employee);
                    newAppraisal.setRating(newRating);
                    employee.setAppraisal(newAppraisal);
                } else {
                    employee.getAppraisal().setRating(newRating);
                }
            }

            return employeeRepository.save(employee);
        }
        return null; // Return null if employee not found
    }
    
    
    @CacheEvict(value = "employees" , allEntries = true)
    public void deleteEmployee(int id) {
    	
    	 employee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));
    	
        employeeRepository.deleteById(id);
    }
}
