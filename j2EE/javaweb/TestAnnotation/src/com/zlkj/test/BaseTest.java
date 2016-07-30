package com.zlkj.test;

import com.zlkj.util.DaoUtil;

public class BaseTest {
	public BaseTest() {
		DaoUtil.daoDi(this);
	}
}
