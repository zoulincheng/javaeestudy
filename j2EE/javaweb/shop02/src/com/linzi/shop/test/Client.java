package com.linzi.shop.test;

import com.linzi.shop.dao.DAOFactory;
import com.linzi.shop.dao.IUserDao;
import com.linzi.shop.model.User;

public class Client {
	public static void main(String[] args) {
		IUserDao userDao = DAOFactory.getUserDao();
		User user = new User();
		user.setUsername("lin");
		user.setNickname("林");
		user.setPassword("123");
		userDao.add(user);
	}
}
