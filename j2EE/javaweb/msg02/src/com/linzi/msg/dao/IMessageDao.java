package com.linzi.msg.dao;

import com.linzi.msg.model.Message;
import com.linzi.msg.model.Pager;

public interface IMessageDao {
	public void add(Message msg, int userId);
	public void update(Message msg);
	public void delete(int id);
	public Message load(int id);
	public Pager<Message> list();
	public int getCommentCount(int msgId);
}
