package com.roman.tradereportingsystem.model.trade;

import com.roman.tradereportingsystem.model.ExternalBroker;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public abstract class Trade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tradeRef;
    private int productId;
    private String productName;
    private String tradeDate;
    private int qty;
    private String buySell;
    private double price;

    @ManyToOne // Many trades can be associated with one externalBroker
    @JoinColumn(name = "broker_id") // Foreign key column in Trade table
    private ExternalBroker externalBroker;

    public Trade(String tradeRef, int productId, String productName, String tradeDate, int qty, String buySell, double price, ExternalBroker externalBroker) {
        this.tradeRef = tradeRef;
        this.productId = productId;
        this.productName = productName;
        this.tradeDate = tradeDate;
        this.qty = qty;
        this.buySell = buySell;
        this.price = price;
        this.externalBroker = externalBroker;
    }

}
