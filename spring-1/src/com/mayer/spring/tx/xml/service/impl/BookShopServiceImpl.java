package com.mayer.spring.tx.xml.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mayer.spring.tx.xml.BookShopDao;
import com.mayer.spring.tx.xml.service.BookShopService;

public class BookShopServiceImpl implements BookShopService {

	private BookShopDao bookShopDao;
	public void setBookShopDao(BookShopDao bookShopDao) {
		this.bookShopDao = bookShopDao;
	}
	
	@Override
	public void purchase(String username, String isbn) {
		int price = bookShopDao.findBookPriceByIsbn(isbn);
		
		bookShopDao.updateBookStock(isbn);
		
		bookShopDao.updateUserAccount(username, price);

	}

}
