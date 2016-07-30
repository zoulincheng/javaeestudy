package com.zlkj.dao;

import java.util.List;

import com.zlkj.model.User;

public class UserMysqlDao implements IUserDao {

	@Override
	public void add(User user) {
		System.out.println("mysql add user");
	}

	@Override
	public void delete(int id) {
		System.out.println("mysql delete user by id");
	}

	@Override
	public void update(User user) {
		System.out.println("mysql update user");
	}

	@Override
	public List<User> list() {
		System.out.println("mysql list user ");
		return null;
	}

	@Override
	public String toString() {
		return "UserMysqlDao [list()=" + list() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
	
}
