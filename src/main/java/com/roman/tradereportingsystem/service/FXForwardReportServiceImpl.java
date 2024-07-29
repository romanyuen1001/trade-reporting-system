package com.roman.tradereportingsystem.service;

import com.roman.tradereportingsystem.model.ExternalBroker;
import com.roman.tradereportingsystem.model.trade.FXForward;
import com.roman.tradereportingsystem.report.FXForwardReportGenerator;
import com.roman.tradereportingsystem.repository.BrokerRepository;
import com.roman.tradereportingsystem.repository.FXForwardRepository;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class FXForwardReportServiceImpl implements FXForwardReportService {

    private final FXForwardRepository FXForwardRepository;
    private final BrokerRepository brokerRepository;

    @PostConstruct
    public void init() {
        // Initialize Brokers
        ExternalBroker externalBrokerA = new ExternalBroker("Broker-A");
        ExternalBroker externalBrokerB = new ExternalBroker("Broker-B");

        brokerRepository.save(externalBrokerA);
        brokerRepository.save(externalBrokerB);

        // Initialize Trades with Brokers
        FXForwardRepository.save(new FXForward("T-FWD-1", 1, "AUDNZD FRD Exp14Jul2021", "20200408", 1000000, "B", 1.067591, externalBrokerA, "20210714"));
        FXForwardRepository.save(new FXForward("T-FWD-2", 2, "AUDUSD FRD Exp15Jul2021", "20200408", 8000000, "S", 0.7518301, externalBrokerA, "20210715"));
        FXForwardRepository.save(new FXForward("T-FWD-3", 3, "EURUSD FRD Exp15Jul2021", "20200408", 25000000, "B", 1.186073, externalBrokerA, "20210715"));

        FXForwardRepository.save(new FXForward("T-FWD-4", 4, "USDJPY FRD Exp16Jul2021", "20200409", 5000000, "B", 109.42, externalBrokerB, "20210716"));
        FXForwardRepository.save(new FXForward("T-FWD-5", 5, "GBPUSD FRD Exp17Jul2021", "20200409", 3000000, "S", 1.2451, externalBrokerB, "20210717"));
    }

    private List<FXForward> getFXForwardsByBroker(String brokerName) {
        return FXForwardRepository.findAll().stream()
                .filter(fxForward -> fxForward.getExternalBroker() != null && brokerName.equals(fxForward.getExternalBroker().getName()))
                .collect(Collectors.toList());
    }

    @Override
    public String getFXForwardReportByBrokerName(String brokerName) {
        List<FXForward> fxForwards = getFXForwardsByBroker(brokerName);
        FXForwardReportGenerator fxForwardReportGenerator = new FXForwardReportGenerator();
        return fxForwardReportGenerator.generateTradeReport(fxForwards);
    }
}
