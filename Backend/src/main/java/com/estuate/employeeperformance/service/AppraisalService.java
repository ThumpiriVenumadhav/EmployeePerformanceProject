package com.estuate.employeeperformance.service;

import com.estuate.employeeperformance.entity.Appraisal;
import com.estuate.employeeperformance.entity.Employee;
import com.estuate.employeeperformance.repository.AppraisalRepository;
import com.estuate.employeeperformance.repository.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class AppraisalService {

    @Autowired
    private AppraisalRepository appraisalRepository;
    
    @Autowired
    private EmployeeRepository employeeRepository;

    // Get all appraisals
    @Cacheable(value = "appraisals")
    public List<Appraisal> getAllAppraisals() {
        return appraisalRepository.findAll();
    }

    // Add new appraisal
    @CacheEvict(value = "appaisals" , allEntries = true)
    public Appraisal addAppraisal(Integer employeeId, String rating) {
    	Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        Appraisal appraisal = new Appraisal();
        appraisal.setEmployee(employee); // Associate the employee
        appraisal.setRating(rating);

        return appraisalRepository.save(appraisal);
    }

    
    public Map<String, Object> getBellCurveReport() {
        List<Appraisal> allAppraisals = appraisalRepository.findAll();
        int totalEmployees = allAppraisals.size();

        // Count employees in each category (A, B, C, D, E)
        int countA = (int) allAppraisals.stream().filter(a -> "A".equals(a.getRating())).count();
        int countB = (int) allAppraisals.stream().filter(a -> "B".equals(a.getRating())).count();
        int countC = (int) allAppraisals.stream().filter(a -> "C".equals(a.getRating())).count();
        int countD = (int) allAppraisals.stream().filter(a -> "D".equals(a.getRating())).count();
        int countE = (int) allAppraisals.stream().filter(a -> "E".equals(a.getRating())).count();

        Map<String, String> expected = new LinkedHashMap<>();
        expected.put("E", "10%");
        expected.put("D", "20%");
        expected.put("C", "40%");
        expected.put("B", "20%");
        expected.put("A", "10%");

        Map<String, String> actual = new LinkedHashMap<>();
        actual.put("E", (countE * 100) / totalEmployees + "%");
        actual.put("D", (countD * 100) / totalEmployees + "%");
        actual.put("C", (countC * 100) / totalEmployees + "%");
        actual.put("B", (countB * 100) / totalEmployees + "%");
        actual.put("A", (countA * 100) / totalEmployees + "%");
        // Deviations from the expected values
        Map<String, String> deviations = new HashMap<>();
        deviations.put("E", ((countA * 100) / totalEmployees - 10) + "%");
        deviations.put("D", ((countB * 100) / totalEmployees - 20) + "%");
        deviations.put("C", ((countC * 100) / totalEmployees - 40) + "%");
        deviations.put("B", ((countD * 100) / totalEmployees - 20) + "%");
        deviations.put("A", ((countE * 100) / totalEmployees - 10) + "%");

        Map<String, Object> bellCurveReport = new HashMap<>();
        bellCurveReport.put("Expected Distribution", expected);
        bellCurveReport.put("Actual Distribution", actual);
        bellCurveReport.put("Deviations", deviations);

        return bellCurveReport;
    }

    
    
    
    
    
    
    
    
    public Map<String, Object> getPerformanceReport() {
        List<Appraisal> allAppraisals = appraisalRepository.findAll();

        int countA = (int) allAppraisals.stream().filter(a -> "A".equals(a.getRating())).count();
        int countB = (int) allAppraisals.stream().filter(a -> "B".equals(a.getRating())).count();
        int countC = (int) allAppraisals.stream().filter(a -> "C".equals(a.getRating())).count();
        int countD = (int) allAppraisals.stream().filter(a -> "D".equals(a.getRating())).count();
        int countE = (int) allAppraisals.stream().filter(a -> "E".equals(a.getRating())).count();

        int totalEmployees = allAppraisals.size();
        
        Map<String, Object> report = new HashMap<>();
        report.put("Category A", (countA * 100) / totalEmployees + "%");
        report.put("Category B", (countB * 100) / totalEmployees + "%");
        report.put("Category C", (countC * 100) / totalEmployees + "%");
        report.put("Category D", (countD * 100) / totalEmployees + "%");
        report.put("Category E", (countE * 100) / totalEmployees + "%");

        return report;
    }


	
}
