package com.ami.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ami.entity.StockPrice;
import com.ami.service.StockPriceService;
import com.ami.utils.Utils;

import reactor.core.publisher.Flux;

@RestController
public class SSEController {

	private List<StockPrice> stockPriceList = new ArrayList<>();

	@Autowired
	Utils utilities;

	@Autowired
	StockPriceService stockPriceService;

	@PostConstruct
	public void initializeStockObjects() {

		StockPrice stock1 = new StockPrice("HDFC BANK", utilities.getRandomDoubleBetweenRange(1000, 5000),
				utilities.getRandomDoubleBetweenRange(5, 15), utilities.getRandomDoubleBetweenRange(1000, 5000),
				utilities.getStatus());

		StockPrice stock2 = new StockPrice("RELIANCE", utilities.getRandomDoubleBetweenRange(1000, 5000),
				utilities.getRandomDoubleBetweenRange(5, 15), utilities.getRandomDoubleBetweenRange(1000, 5000),
				utilities.getStatus());

		StockPrice stock3 = new StockPrice("SBI", utilities.getRandomDoubleBetweenRange(1000, 5000),
				utilities.getRandomDoubleBetweenRange(5, 15), utilities.getRandomDoubleBetweenRange(1000, 5000),
				utilities.getStatus());

		stockPriceList.add(stock1);
		stockPriceList.add(stock2);
		stockPriceList.add(stock3);
	}

	@GetMapping(value = "/stockprice", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<List<StockPrice>> getStockPrice() {
		return stockPriceService.getStockPriceData(stockPriceList);
	}

}
