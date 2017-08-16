package com.mayer.spring.tx;

import java.util.List;

public interface Cashier {
	public void checkOut(String username, List<String> isbns);
} 
