package com.roman.tradereportingsystem.report;

import com.roman.tradereportingsystem.model.trade.Trade;

import java.util.List;

public interface TradeReportGenerator {
    String generateTradeReport(List<? extends Trade> trades);
}
