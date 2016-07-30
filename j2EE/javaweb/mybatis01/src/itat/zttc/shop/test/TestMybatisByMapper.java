package itat.zttc.shop.test;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import itat.zttc.shop.mapper.UserMapper;
import itat.zttc.shop.model.User;
import itat.zttc.shop.util.MybatisUtil;

public class TestMybatisByMapper {
	
	@Test
	public void testAdd(){
		SqlSession session = null;
		try {
			session = MybatisUtil.createSession();
			User user = new User();
			user.setNickname("猪八戒");
			user.setPassword("123");
			user.setType(1);
			user.setUsername("bajie");
			session.getMapper(UserMapper.class).add(user);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		} finally {
			MybatisUtil.closeSession(session);
		}
	}
	
	@Test
	public void testList(){
		SqlSession session = null;
		try {
			session = MybatisUtil.createSession();
			List<User> us = session.getMapper(UserMapper.class).list();
			for(User u:us){
				System.out.println(u.getNickname());
			}
		} finally {
			MybatisUtil.closeSession(session);
		}
	}
}
