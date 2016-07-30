package com.linzi.msg.test;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import com.linzi.msg.dao.DAOFactory;
import com.linzi.msg.dao.IUserDao;
import com.linzi.msg.model.User;


public class TestInit {

	static String[] firstName = new String[]{"张","刘","牛","李","吕","付","副","王","汪","赵",
			"孔","谭","夏侯","上官","欧阳","贪","东方","曹","司马","诸葛","关","孙","甘","何",
			"秦","邹","马","候"};
	static String[] centerName = {"云","硕","和","修","高","可","一","大","下","冬","河","美","田","甜"};
	static String[] lastName = new String[]{"立","住","共","都","高","路","恶","人","达","云","雨","摸","亮","子"
			,"强","备","正","风","大","小","关","娟","丽","木","燕","号","浩","然","火","水","溜","柳","鱼","春","秋","天"};

	static Random ran = new Random();
	
	public static void main(String[] args) {
		IUserDao userDao = DAOFactory.getUserDao();
		for (int i = 0; i < 500; i++){
			User user = new User();
			user.setNickname(ranName());
			user.setPassword("123");
			user.setUsername("user"+i);
			user.setStatus(0);
			user.setType(0);
			userDao.add(user);
		}
	}
	
	
	private static String ranName(){
		int num = ran.nextInt(5);
		if (num < 2) {
			//三个字
			return firstName[ran.nextInt(firstName.length)]
					+ centerName[ran.nextInt(centerName.length)]
					+ lastName[ran.nextInt(lastName.length)];
		}else {
			return firstName[ran.nextInt(firstName.length)] 
					+ lastName[ran.nextInt(lastName.length)];
		}
	}
	

	
	public static long randomRange(long start, long end){
		return (long)(Math.random() * (end -start) + start);
	}
	
}
