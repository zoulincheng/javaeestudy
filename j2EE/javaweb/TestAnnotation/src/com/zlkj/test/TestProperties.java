package com.zlkj.test;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;

import com.zlkj.model.User;

public class TestProperties {
	public static void main(String[] args) {
		Properties testpro = new Properties();
		try {
			testpro.load(TestProperties.class.getClassLoader().getResourceAsStream("test.properties"));
			String name = testpro.getProperty("name");
			String password = testpro.getProperty("password");
			System.out.println(name + ":"+ password);
			
			String classS = testpro.getProperty("user");
			User user = (User) Class.forName(classS).newInstance();
			user.setId(1);
			user.setName("zhangsan");
			user.setPassword("123");
			
//			Method[] methods = 
			
			System.out.println(user);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
