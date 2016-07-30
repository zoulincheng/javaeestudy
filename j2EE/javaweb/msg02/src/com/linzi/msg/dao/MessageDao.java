package com.linzi.msg.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.linzi.msg.model.Message;
import com.linzi.msg.model.MsgException;
import com.linzi.msg.model.Pager;
import com.linzi.msg.model.SystemContext;
import com.linzi.msg.model.User;
import com.linzi.msg.util.DBUtil;

public class MessageDao implements IMessageDao {
	private IUserDao userDao;
	
	public MessageDao() {
		userDao = DAOFactory.getUserDao();
	}
	
	@Override
	public void add(Message msg, int user_id) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			if (userDao.load(user_id) == null){
				throw new MsgException("添加留言的用户不存在");
			}
			con = DBUtil.getConnection();
			String sql = "insert into t_msg (title,content,post_date,user_id) values (?, ?, ?, ?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, msg.getTitle());
			ps.setString(2, msg.getContent());
			ps.setTimestamp(3, new Timestamp(new Date().getTime()));
			ps.setInt(4, user_id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(ps);
			DBUtil.close(con);
		}
	}

	@Override
	public void update(Message msg) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = DBUtil.getConnection();
			String sql = "update t_msg set title=?,content=? where id=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, msg.getTitle());
			ps.setString(2, msg.getContent());
			ps.setInt(3, msg.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(ps);
			DBUtil.close(con);
		}
	}

	@Override
	public void delete(int id) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = DBUtil.getConnection();
			String sql = "delete from t_comment where msg_id=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
			
			sql = "delete from t_msg where id = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			DBUtil.close(ps);
			DBUtil.close(con);
		}
	}

	@Override
	public Message load(int id) {
		Message msg = null;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = DBUtil.getConnection();
			String sql = "select * from t_msg where id=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while(rs.next()){
				msg = new Message();
				msg.setContent(rs.getString("content"));
				msg.setId(rs.getInt("id"));
				msg.setPostDate(new Date(rs.getTimestamp("post_date").getTime()));
				msg.setTitle(rs.getString("title"));
				msg.setUserId(rs.getInt("user_id"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs);
			DBUtil.close(ps);
			DBUtil.close(con);
		}
		return msg;
	}

	@Override
	public Pager<Message> list() {
		Pager<Message> pages = new Pager<Message>();
		Message msg = null;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int pageOffset = SystemContext.getPageOffset();
		int pageSize = SystemContext.getPageSize();
		pages.setPageOffset(pageOffset);
		pages.setPageSize(pageSize);
		List<Message> datas = new ArrayList<Message>();
		pages.setDatas(datas);
		
		try {
			con = DBUtil.getConnection();
			String sql = "select * from t_msg order by post_date desc limit ?,?";
			String sqlCount = "select count(*) from t_msg";
			ps = con.prepareStatement(sql);
			ps.setInt(1, pageOffset);
			ps.setInt(2, pageSize);
			rs = ps.executeQuery();
			while(rs.next()){
				msg = new Message();
				msg.setContent(rs.getString("content"));
				msg.setId(rs.getInt("id"));
				msg.setPostDate(new Date(rs.getTimestamp("post_date").getTime()));
				msg.setTitle(rs.getString("title"));
				msg.setUserId(rs.getInt("user_id"));
				datas.add(msg);
			}
			ps = con.prepareStatement(sqlCount);
			rs = ps.executeQuery();
			while(rs.next()){
				int totalRecord = rs.getInt(1);
				int totalPage = (totalRecord-1)/pageSize + 1;
				pages.setTotalRecord(totalRecord);
				pages.setTotalPage(totalPage);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs);
			DBUtil.close(ps);
			DBUtil.close(con);
		}
		return pages;
	}
	
	@Override
	public int getCommentCount(int msgId) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int count = 0;
		try {
			con = DBUtil.getConnection();
			String sql = "select count(*) from t_comment where msg_id=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, msgId);
			rs = ps.executeQuery();
			while(rs.next()){
				count = rs.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs);
			DBUtil.close(ps);
			DBUtil.close(con);
		}

		return count;
	}
}
