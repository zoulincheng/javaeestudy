package com.zlkj.test;

import org.junit.Test;

import com.zlkj.dao.IUserDao;
import com.zlkj.model.ShopDi;
import com.zlkj.model.User;

public class TestUserDao  extends BaseTest{
	private IUserDao userDao;
	
	public IUserDao getUserDao() {
		return userDao;
	}
	
	@ShopDi
	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}



	@Test 
	public void testAdd(){
		User user = new User();
		user.setId(1);
		user.setName("zhangsan");
		user.setPassword("123");
		userDao.list();
	}
}
