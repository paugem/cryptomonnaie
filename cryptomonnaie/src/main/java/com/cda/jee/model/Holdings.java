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
public class Holdings {
	private int idHoldings;
	private String nameCurrency;
	private int quantity;
	private Float purchasePrice;
	private Date purchaseDate;
	private Float currentPrice;
	private Float delta;
	
}
