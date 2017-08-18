package com.mayer.spring.hibernate.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mayer.spring.hibernate.dao.BookShopDao;
import com.mayer.spring.hibernate.service.BookShopService;

@Service
public class BookShopServiceImpl implements BookShopService {

	@Autowired
	private BookShopDao bookShopDao;
	@Override
	public void purchase(String username, String isbn) {
		int price = bookShopDao.findBookPriceByIsbn(isbn);
		bookShopDao.updateBookStock(isbn);
		bookShopDao.updateUserAccount(username, price);

	}

}
