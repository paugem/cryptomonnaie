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
	
}
