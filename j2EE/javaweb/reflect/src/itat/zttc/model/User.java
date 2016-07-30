package itat.zttc.model;

public class User {
	
	private int id;
	private String username;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String show(String str) {
		return str + " [id=" + id + ", username=" + username + "]";
	}
	
	
	public static void say(String hello, String world){
		System.out.println(hello + "HAHA," + world);
	}
 }
