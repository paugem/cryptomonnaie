package com.cda.jee.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Currency {
	private int idCurrency;
	private String nameCurrency;
	private String label;
	private Float currentPrice;
	
	public Currency(String pNameCurrency, String pLabel, Float pCurrentPrice) {
		this.nameCurrency=pNameCurrency;
		this.label=pLabel;
		this.currentPrice=pCurrentPrice;
	}
}

