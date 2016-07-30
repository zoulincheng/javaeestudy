package itat.zttc.shop.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisUtil {
	private static  SqlSessionFactory FACTORY;
	
	static {
		try {
			InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
			FACTORY = new SqlSessionFactoryBuilder().build(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static SqlSession createSession(){
		return FACTORY.openSession();
	}
	
	public static void closeSession(SqlSession session){
		if (session != null)
			session.close();
	}
	
}
