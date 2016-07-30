package com.linzi.msg.test;

import java.io.IOException;
import java.util.Properties;

public class TestProperties {
	public static void main(String[] args) {
		try {
			Properties properties =  new Properties();
			properties.load(TestProperties.class.getClassLoader().getResourceAsStream("jdbc.properties"));
			String username = properties.getProperty("username");
			String password = properties.getProperty("password");
			String url = properties.getProperty("rul");
			System.out.println(username);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
