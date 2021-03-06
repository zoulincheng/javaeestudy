package itat.zttc.shop.test;

import java.lang.reflect.Method;

import org.junit.Test;

import itat.zttc.shop.model.ShopDi;

public class TestAnnotation {
	
	@ShopDi("addressDao")
	public void aa(){
		
	}
	
	@ShopDi
	public void setUserDao(){
		
	}
	
	@Test
	public void test01(){
		Method[] ms = this.getClass().getDeclaredMethods();
		for(Method m:ms){
			System.out.println(m.getName()+":"+m.isAnnotationPresent(ShopDi.class));
			if (m.isAnnotationPresent(ShopDi.class)){
				ShopDi sDi = m.getAnnotation(ShopDi.class);
				String v = sDi.value();
				if (v == null || "".equals(v.trim())){
					v = m.getName().substring(3);
				}
				System.out.println("v:"+v);
			}
		}
	}
}
