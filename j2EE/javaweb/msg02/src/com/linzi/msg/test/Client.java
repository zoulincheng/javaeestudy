package com.linzi.msg.test;

import com.linzi.msg.dao.DAOFactory;
import com.linzi.msg.dao.IUserDao;
import com.linzi.msg.model.User;

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
