package itat.zttc.shop.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import itat.zttc.shop.model.User;

public class TestMyFirstMybatis {
	public static void main(String[] args) {
		testUpdate();
	}
	
	private static void testUpdate(){
		try {
			//1 创建配置文件mybatis-config.xml  resource mybatis 
			InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
			//2 创建SQLSessionFactory
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
			//3 创建SQLSession
			SqlSession session = factory.openSession();
			//4 调用mapper文件插入数据  需要将mapper文件加入到config文件中
			User user = new User();
			//user.setUsername("wukong") ;
			user.setNickname("孙悟空");
			user.setPassword("123456");
			user.setType(0);
			user.setId(5);
			session.update("itat.zttc.shop.model.User.update", user);
			session.commit();
			session.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void testAdd(){
		try {
			//1 创建配置文件mybatis-config.xml  resource mybatis 
			InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
			//2 创建SQLSessionFactory
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
			//3 创建SQLSession
			SqlSession session = factory.openSession();
			//4 调用mapper文件插入数据  需要将mapper文件加入到config文件中
			User user = new User();
			user.setUsername("wukong") ;
			user.setNickname("孙悟空");
			user.setPassword("123");
			user.setType(0);
			session.insert("itat.zttc.shop.model.User.add", user);
			session.commit();
			session.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
