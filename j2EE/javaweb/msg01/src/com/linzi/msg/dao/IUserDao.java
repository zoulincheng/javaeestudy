package com.linzi.msg.dao;

import java.util.List;

import com.linzi.msg.model.Pager;
import com.linzi.msg.model.User;

public interface IUserDao {
	public void add(User user);
	public void delete(int id);
	public void update(User user);
	public User load(int id);
	public Pager<User> list(String con);
	public User login(String username, String password);
}
