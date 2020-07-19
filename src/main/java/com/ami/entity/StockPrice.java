package com.ami.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StockPrice {

	private String companyName;
	private String price;
	private String change;
	private String value;
	private String status;
}