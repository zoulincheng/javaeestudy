package itat.zttc.shop.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

import itat.zttc.shop.dao.IFactoryDao;
import itat.zttc.shop.model.ShopDi;

public class DaoUtil {
	
//	public static void main(String[] args) {
//		System.out.println(createDaoFactory());
//	}
//	
	
	public static void diDao(Object obj){
		try {
			Method[] ms = obj.getClass().getDeclaredMethods();
			for (Method method : ms){
				if (method.isAnnotationPresent(ShopDi.class)){
					ShopDi sd = method.getAnnotation(ShopDi.class);
					String mString = sd.value();
					if (mString == null || "".equals(mString.trim())){
						mString = method.getName().substring(3);
						mString = mString.substring(0,1).toLowerCase() + mString.substring(1);
					}
					Object objParam = DaoUtil.createDaoFactory().getDao(mString);
					method.invoke(obj, objParam);
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
	
	
	
//	public static void diDao(Object object){
//		try {
//			/**
//			 * 获取自己的所有方法
//			 */
//			Method[] methods = object.getClass().getDeclaredMethods();
//			for(Method method : methods){
//				/**
//				 * 获取方法name
//				 */
//				String methodName = method.getName();
//				/**
//				 * 获取set method
//				 */
//				if(methodName.startsWith("set")){
//					/**
//					 * 获取需要set需要注入的dao
//					 */
//					methodName = methodName.substring(3);
//					methodName = methodName.substring(0, 1).toLowerCase()+methodName.substring(1);
//					/**
//					 * 调用工厂方法，获取该DAO
//					 */
//					Object obj = DaoUtil.createDaoFactory().getDao(methodName);
//					method.invoke(object, obj);
//				}
//			}
//		} catch (SecurityException e) {
//			e.printStackTrace();
//		} catch (IllegalAccessException e) {
//			e.printStackTrace();
//		} catch (IllegalArgumentException e) {
//			e.printStackTrace();
//		} catch (InvocationTargetException e) {
//			e.printStackTrace();
//		}
//	}
	
	
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
