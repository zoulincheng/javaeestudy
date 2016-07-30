package com.linzi.msg.dao;

import com.linzi.msg.model.Comment;
import com.linzi.msg.model.Pager;

public interface ICommentDao {
	public void add(Comment comment, int userId, int msgId);
	public void delete(int id);
	public Comment load(int id);
	/**
	 * 根据留言获取该留言所有评论
	 * @param msg_id
	 * @return
	 */
	public Pager<Comment> list(int msg_id);
}
