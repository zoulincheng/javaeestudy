package itat.zttc.shop.dao;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import itat.zttc.shop.util.PropertiesUtil;

public class PropertiesFactory implements IFactoryDao {

	private static IFactoryDao factory = new PropertiesFactory();
	private static Map<String, Object> daos = new HashMap<String, Object>();
	
	private PropertiesFactory() {
		
	}
	
	public static IFactoryDao getInstance(){
		return factory;
	}
	
	@Override
	public Object getDao(String daoName) {
		try {
			if (daos.containsKey(daoName))
				return daos.get(daoName);
			Properties properties = PropertiesUtil.getDaoProp();
			String className = properties.getProperty(daoName);
			Object object = Class.forName(className).newInstance();
			daos.put(daoName, object);
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
