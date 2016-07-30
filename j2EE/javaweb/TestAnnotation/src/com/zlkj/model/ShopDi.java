package com.zlkj.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface ShopDi {
	String abc() default "";
	String value() default "";
}
