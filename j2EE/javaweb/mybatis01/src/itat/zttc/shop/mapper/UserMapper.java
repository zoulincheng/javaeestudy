package itat.zttc.shop.mapper;

import java.util.List;

import itat.zttc.shop.model.User;

public interface UserMapper {
	public void add(User user);
	public void update(User user);
	public void delete(int id);
	public User load(int id);
	public List<User> list();
}
