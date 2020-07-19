package com.ami.utils;

import java.text.DecimalFormat;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.stereotype.Component;

@Component
public class Utils {

	public String getRandomDoubleBetweenRange(double min, double max) {

		String pattern = "###,###.##";
		DecimalFormat decimalFormat = new DecimalFormat(pattern);
		return decimalFormat.format((Math.random() * ((max - min) + 1)) + min);
	}

	public String getStatus() {

		int i = ThreadLocalRandom.current().nextInt(0, 1 + 1);
		String[] status = { "HIGH", "LOW" };
		return status[i];
	}

}