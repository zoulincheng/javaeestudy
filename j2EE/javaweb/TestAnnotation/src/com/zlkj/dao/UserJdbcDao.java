package com.zlkj.dao;

import java.util.List;

import com.zlkj.model.User;

public class UserJdbcDao implements IUserDao {

	@Override
	public void add(User user) {
		System.out.println("jdbc add user");

	}

	@Override
	public void delete(int id) {
		System.out.println("jdbc delete user");

	}

	@Override
	public void update(User user) {
		System.out.println("jdbc update user");
	}

	@Override
	public List<User> list() {
		System.out.println("jdbc list user");
		return null;
	}

}
