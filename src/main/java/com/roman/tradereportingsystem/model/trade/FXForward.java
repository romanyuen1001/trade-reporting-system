package com.roman.tradereportingsystem.model.trade;

import com.roman.tradereportingsystem.model.ExternalBroker;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class FXForward extends Trade {
    private String expirationDate;

    public FXForward(String tradeRef, int productId, String productName, String tradeDate, int qty, String buySell, double price, ExternalBroker externalBroker, String expirationDate) {
        super(tradeRef, productId, productName, tradeDate, qty, buySell, price, externalBroker);
        this.expirationDate = expirationDate;
    }
}
