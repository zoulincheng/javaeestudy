package com.zlkj.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

import com.zlkj.dao.IFactoryDao;
import com.zlkj.model.ShopDi;

public class DaoUtil {
	public static final int SETTER_INDEX = 3;
	public static void daoDi(Object objDi){
		try {
			Method[] methods = objDi.getClass().getDeclaredMethods();
			for (Method method : methods){
				if (method.isAnnotationPresent(ShopDi.class)){
					ShopDi shopDi = method.getAnnotation(ShopDi.class);
					String methodValue = shopDi.value();
					if (methodValue == null || "".equals(methodValue.trim())){
						methodValue = method.getName().substring(SETTER_INDEX);
						methodValue = methodValue.substring(0, 1).toLowerCase() + methodValue.substring(1);
					}
					System.out.println(methodValue);
					Object objParam = DaoUtil.createDaoFactory().getDao(methodValue);
					method.invoke(objDi, objParam);
				}
			}
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}
	
	public static IFactoryDao createDaoFactory(){
		IFactoryDao factoryDao = null;
		
		try {
			Properties daopro = PropertiesUtil.getDaopro();
			System.out.println(daopro);
			String factoryS = daopro.getProperty("factory");
			System.out.println(factoryS);
			Class clz = Class.forName(factoryS);
			String methodS = "getInstance";
			Method method = clz.getMethod(methodS);
			factoryDao = (IFactoryDao)method.invoke(clz);
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
		System.out.println(factoryDao);
		return factoryDao;
	}
}
