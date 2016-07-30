package com.linzi.model;

public class User {
	private int id;
	private String username;
	private String nickname;
	
	public User(int id, String username, String nickname) {
		super();
		this.id = id;
		this.username = username;
		this.nickname = nickname;
	}
	
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
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	@Override
	public String toString() {
		return "["+this.getId()+":"+this.getUsername()+":"+this.getNickname()+"]";
	}
}
