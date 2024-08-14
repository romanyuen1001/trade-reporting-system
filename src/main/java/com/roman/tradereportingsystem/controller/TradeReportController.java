package com.roman.tradereportingsystem.controller;

import com.roman.tradereportingsystem.service.FXForwardReportServiceImpl;
import com.roman.tradereportingsystem.utils.ProductType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping("/api/reports")
public class TradeReportController {

    @Autowired
    private FXForwardReportServiceImpl fXForwardReportServiceImpl;

    // TODO: Modify this func to be generic as filter - use dto for retrieving product type, broker name, etc
    @GetMapping("/{productType}/{brokerName}")
    public ResponseEntity<String> generateReportByProduceTypeAndBrokerName(
            @PathVariable String productType,
            @PathVariable String brokerName) {
        // TODO: Introduce the factory pattern in controller to handle checking logic
        // TODO: Handle spacing in param 'FX Forward Trade' for enum
        if (!Objects.equals(productType, ProductType.FxForward.name())) {
            return ResponseEntity.badRequest().body("Invalid product type. Please try '" + ProductType.FxForward.name() + "'");
        }
        try {
            String report = fXForwardReportServiceImpl.getFXForwardReportByBrokerName(brokerName);
            return ResponseEntity.ok(report);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error generating report: " + e.getMessage());
        }
    }
}
