package com.roman.tradereportingsystem.report;

import com.roman.tradereportingsystem.model.trade.FXForward;
import com.roman.tradereportingsystem.model.trade.Trade;

import java.util.List;

public class FXForwardReportGenerator implements TradeReportGenerator {
    @Override
    public String generateTradeReport(List<? extends Trade> fxForwards) {
        StringBuilder reportBuilder = new StringBuilder();
        reportBuilder.append("tradeRef,productId,productName,tradeDate,qty,buySell,price\n");

        List<FXForward> filteredFxForwards = fxForwards.stream()
                .filter(FXForward.class::isInstance)
                .map(FXForward.class::cast)
                .toList();

        for (FXForward fxForward : filteredFxForwards) {
            reportBuilder.append(String.format("%s,%d,%s,%s,%d,%s,%f\n",
                    fxForward.getTradeRef(),
                    fxForward.getProductId(),
                    fxForward.getProductName(),
                    fxForward.getTradeDate(),
                    fxForward.getQty(),
                    fxForward.getBuySell(),
                    fxForward.getPrice()));
        }

        return reportBuilder.toString();
    }
}
