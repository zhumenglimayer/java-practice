package com.mayer.spring.hibernate.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mayer.spring.hibernate.dao.BookShopDao;
import com.mayer.spring.hibernate.execption.BookStockException;
import com.mayer.spring.hibernate.execption.UserAccountException;

@Repository
public class BookShopDaoImpl implements BookShopDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSession(){
		return sessionFactory.getCurrentSession();
	}

	@Override
	public int findBookPriceByIsbn(String isbn) {
		String hql = "SELECT b.price FROM Book b WHERE b.isbn = ?";
		Query<Object> query = getSession().createQuery(hql).setParameter(0, isbn);
		return (Integer)query.uniqueResult();
	}

	@Override
	public void updateBookStock(String isbn) {
		String hql2= "SELECT b.stock FROM Book b WHERE b.isbn = ?";
		int stock = (int) getSession().createQuery(hql2).setParameter(0, isbn).uniqueResult();
		if(stock == 0){
			throw new BookStockException("库存不足！");
		}
		
		String hql = "UPDATE Book b SET b.stock = b.stock - 1 WHERE b.isbn = ?";
		getSession().createQuery(hql).setParameter(0, isbn).executeUpdate();

	}

	@Override
	public void updateUserAccount(String username, int price) {
		String hql2 = "SELECT a.balance FROM Account a WHERE a.userName = ?";
		int balance = (int) getSession().createQuery(hql2).setParameter(0, username).uniqueResult();
		if(balance < price){
			throw new UserAccountException("余额不足！");
		}
		String hql = "UPDATE Account a SET a.balance = a.balance - ? WHERE a.userName = ?";
		getSession().createQuery(hql).setParameter(0, price).setParameter(1, username).executeUpdate();

	}

}
