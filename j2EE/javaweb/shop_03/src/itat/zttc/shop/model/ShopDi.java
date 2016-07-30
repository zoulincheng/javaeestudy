package itat.zttc.shop.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author Administrator
 * 使用Annotation来标注需要依赖注入的方法
 * @ShopDi("userDao")说明方法注入userDao对象
 * 如果@ShopDi就规定该方法使用setXX来注入,如果方法是setUserDao表示注入userDao
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface ShopDi {
	/**
	 * 表示这个Annotation 加了一个属性值，如果没有定义default，必须在Annotation中定义
	 * 这个属性
	 * @ShopDi(abc="aaa")
	 * @return
	 */
	String abc() default "";
	
	/**
	 * value 是Annotation的默认属性，在定义是可以不用value=""定义
	 * 而直接通过ShopDi("hello")使用
	 * 特别注意，当需要定义两个以上属性时，默认的属性就不起作用了
	 * ShopDi(value="afdf")
	 * @return
	 */
	String value() default "";
}
