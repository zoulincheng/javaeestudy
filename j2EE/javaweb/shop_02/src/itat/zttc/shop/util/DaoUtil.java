package itat.zttc.shop.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

import itat.zttc.shop.dao.IFactoryDao;

public class DaoUtil {
	
//	public static void main(String[] args) {
//		System.out.println(createDaoFactory());
//	}
//	
	public static IFactoryDao createDaoFactory(){
		IFactoryDao  factory = null;
		try {
			Properties prop = PropertiesUtil.getDaoProp();
			String fs = prop.getProperty("factory");
			Class clz = Class.forName(fs);
			String methodName = "getInstance";
			Method method = clz.getMethod(methodName);
			factory = (IFactoryDao)method.invoke(clz);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return factory;
	}
}
