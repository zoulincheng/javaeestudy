package com.linzi.model;

import java.util.ArrayList;
import java.util.List;

public class UserInit {
	public static List<User> initUser(){
		List<User> users = new ArrayList<User>();
		users.add(new User(1, "wukong", "悟空"));
		users.add(new User(2, "bajie", "八戒"));
		users.add(new User(3, "shashen", "沙僧"));
		users.add(new User(4, "tangsheng", "唐僧"));
		return users;
	}
}
