package com.cda.jee.model;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Holding {
	private int idHoldings;
	private String nameCurrency;
	private int quantity;
	private Float purchasePrice;
	private Date purchaseDate;
	private Float currentPrice;
	private Float delta;
	
	public Holding (String pNameCurrency, int pQuantity, Float pPurchasePrice, Date pPurchaseDate, Float pCurrentPrice, Float pDelta) {
		this.nameCurrency = pNameCurrency;
		this.quantity=pQuantity;
		this.purchasePrice=pPurchasePrice;
		this.purchaseDate=pPurchaseDate;
		this.currentPrice=pCurrentPrice;
		this.delta=pDelta;
	}
}
