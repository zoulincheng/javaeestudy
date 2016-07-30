package com.zlkj.util;

import java.io.IOException;
import java.util.Properties;

public class PropertiesUtil {
	private static Properties daoPro;
	
	public static Properties getDaopro(){
		try {
			if (daoPro == null){
				daoPro = new Properties();
				daoPro.load(PropertiesUtil.class.getClassLoader().getResourceAsStream("dao.properties"));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return daoPro;
	}
}
