package com.linzi.shop.dao;

public class DAOFactory {
	public static IUserDao getUserDao(){
		return new UserDao();
	}
}
