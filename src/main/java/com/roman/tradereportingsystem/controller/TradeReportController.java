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
    private FXForwardReportServiceImpl FXForwardReportServiceImpl;

    @GetMapping("/{productType}/{brokerName}")
    public ResponseEntity<String> generateReportByProduceTypeAndBrokerName(
            @PathVariable String productType,
            @PathVariable String brokerName) {
        // TODO: Introduce switch case for product types, or make some specific APIs
        if (!Objects.equals(productType, ProductType.FxForward.name())) {
            return ResponseEntity.badRequest().body("Invalid product type. Please try '" + ProductType.FxForward.name() + "'");
        }
        try {
            String report = FXForwardReportServiceImpl.getFXForwardReportByBrokerName(brokerName);
            return ResponseEntity.ok(report);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error generating report: " + e.getMessage());
        }
    }
}
