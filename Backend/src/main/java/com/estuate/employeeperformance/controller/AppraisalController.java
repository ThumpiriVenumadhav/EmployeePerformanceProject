package com.estuate.employeeperformance.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estuate.employeeperformance.entity.Appraisal;
import com.estuate.employeeperformance.service.AppraisalService;

@RestController
@RequestMapping("/appraisals")
public class AppraisalController {

    @Autowired
    private AppraisalService appraisalService;

    
    @GetMapping
    public List<Appraisal> getAllAppraisals(){
    	
    	return appraisalService.getAllAppraisals();
    }
    
    
    @GetMapping("/bellcurve")
    public ResponseEntity<Map<String, Object>> getBellCurveReport() {
        Map<String, Object> report = appraisalService.getBellCurveReport();
        return ResponseEntity.ok(report);
    }

    
    @GetMapping("/report")
    public ResponseEntity<Map<String, Object>> getPerformanceReport() {
        Map<String, Object> report = appraisalService.getPerformanceReport();
        return ResponseEntity.ok(report);
    }
    
    

    // Add new appraisal
    @PostMapping
    public ResponseEntity<Appraisal> addAppraisal(@RequestBody Map<String, Object> request) {
        Integer employeeId = (int) Long.parseLong(request.get("employeeId").toString());
        String rating = request.get("rating").toString();

        Appraisal appraisal = appraisalService.addAppraisal(employeeId, rating);
        return ResponseEntity.ok(appraisal);
    }
}

