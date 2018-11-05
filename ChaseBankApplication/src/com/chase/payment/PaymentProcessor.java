package com.chase.payment;

import java.util.Random;

public class PaymentProcessor {
	
	public String ping() {
		return "1";
	}
	
	public String processPayment(CreditCardPayment card) {
		
		Random random = new Random();
    	int orderNum = random.nextInt(10000000);
    	String confirmId = String.format("%12d", orderNum).replace(" ", "0");
    	return confirmId;
    	
	}
		
}
