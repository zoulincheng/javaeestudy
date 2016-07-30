package itat.zttc.shop.test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Assert;
import org.junit.Test;

import itat.zttc.shop.model.User;
import itat.zttc.shop.util.MybatisUtil;

public class TestMyBatis {

	@Test
	public void testDelete(){
		try {
			InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
			SqlSession session = factory.openSession();
			session.delete(User.class.getName()+".delete", 5);
			session.commit();
			session.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testLoad(){
		SqlSession session = null;
		try {
			session = MybatisUtil.createSession();
			User user = (User)session.selectOne(User.class.getName()+".load", 1);
			System.out.println(user.getNickname());
		} finally {
			MybatisUtil.closeSession(session);
		}
	}
	
	@Test
	public void testAdd(){
		SqlSession session = null;
		try {
			session = MybatisUtil.createSession();
			User user = new User();
			user.setUsername("wukong") ;
			user.setNickname("孙悟空");
			user.setPassword("123");
			user.setType(0);
			session.insert(User.class.getName()+".add", user);
			session.commit();
		} catch (Exception e){
			session.rollback();
		}finally {
			MybatisUtil.closeSession(session);
		}
	}
	
	@Test
	public void testList(){
		SqlSession session = null;
		try {
			session = MybatisUtil.createSession();
			List<User> users = session.selectList(User.class.getName()+".list", null);
			for (User user:users){
				System.out.println(user.getNickname());
			}
		}finally {
			MybatisUtil.closeSession(session);
		}	
	}
}
 