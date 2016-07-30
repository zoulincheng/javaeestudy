package com.zlkj.dao;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import com.zlkj.util.PropertiesUtil;

public class PropertiesFactoryDao implements IFactoryDao {
	private static PropertiesFactoryDao factory = new PropertiesFactoryDao();
	private static Map<String, Object> daos = new HashMap<String, Object>();
	
	private  PropertiesFactoryDao() {
	}
	
	public static IFactoryDao getInstance(){
		return factory;
	}
	
	@Override
	public Object getDao(String daoName) {
		try {
			if (daos.containsKey(daoName)){
				System.out.println("11111");
				return daos.get(daoName);
			}
			Properties daopro = PropertiesUtil.getDaopro();
			String clzS = daopro.getProperty(daoName);
			Object object = Class.forName(clzS).newInstance();
			daos.put(daoName, object);
			System.out.println("222");
			return object;
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

}