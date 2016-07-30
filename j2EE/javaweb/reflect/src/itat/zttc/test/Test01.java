package itat.zttc.test;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Test;

import itat.zttc.model.IUserDao;
import itat.zttc.model.User;
import itat.zttc.model.UserADao;

public class Test01 {

	@Test
	public void test01() {
		User user = new User();
		user.setId(1);
		user.setUsername("abcd");
		System.out.println(user.show("User"));
	}
	
	@Test
	public void test02(){

		try {
			String objStr = "itat.zttc.model.User";
			Class clz = Class.forName(objStr);
			User u = (User)clz.newInstance();
			u.setId(1);
			u.setUsername("abc");
			System.out.println(u.show("user1"));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
	
	
	
	@Test
	public void test03(){

		try {
			String objStr = "itat.zttc.model.User";
			Class clz = Class.forName(objStr);
			User u = (User)clz.newInstance();
			u.setId(1);
			u.setUsername("abc");
			String mm = "show";
			/**
			 * 第一个是函数的名称，第二个参数是...（表示有无限个参数）表示函数的参数
			 */
			Method method = clz.getMethod(mm, String.class);
			/**
			 * 第一个参数是调用函数的对象，第二个参数是函数执行时的参数
			 */
			String string = (String)method.invoke(u, "abc");
			
			System.out.println(string);
			
			/**
			 * 同样可以调用static方法
			 */
			Method m2 = clz.getMethod("say", String.class, String.class);
			/**
			 * 调用staic方法是用类
			 */
			m2.invoke(clz, "ok", "world");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testDao01(){
		IUserDao u1 = new UserADao();
		u1.add();
	}
	
	@Test
	public void testDao02(){
		try {
			String dao = "itat.zttc.model.UserCDao";
			IUserDao u = (IUserDao)Class.forName(dao).newInstance();
			u.add();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
