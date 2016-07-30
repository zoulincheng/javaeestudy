package com.linzi.msg.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.linzi.msg.model.MsgException;
import com.linzi.msg.model.Pager;
import com.linzi.msg.model.SystemContext;
import com.linzi.msg.model.User;
import com.linzi.msg.util.DBUtil;

public class UserDao implements IUserDao {

	@Override
	public void add(User user) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = DBUtil.getConnection();
			String sql = "select count(*) from t_user where username=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			rs = ps.executeQuery();
			while(rs.next()){
				if (rs.getInt(1) > 0) throw new MsgException("添加的用户已经存在，不能继续添加");
			}
			sql = "insert into t_user values(null,?,?,?,?,?)";
			//sql = "insert into t_user values(null,?,?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getNickname());
			ps.setInt(4, user.getStatus());
			ps.setInt(5, user.getType());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs);
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
			User u = this.load(id);
			if (u.getUsername().equals("admin")){
				throw new MsgException("不能删除管理员");
			}
			String sql = "delete from t_user where id=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(ps);
			DBUtil.close(con);
		}
	
	}

	@Override
	public void update(User user) {
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = DBUtil.getConnection();
			String sql = "update t_user set password=?,nickname=?,type=?,status=? where id =?";
			ps = con.prepareStatement(sql);
			ps.setString(1, user.getPassword());
			ps.setString(2, user.getNickname());
			ps.setInt(3, user.getType());
			ps.setInt(4, user.getStatus());
			ps.setInt(5, user.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(ps);
			DBUtil.close(con);
		}
	
	}

	@Override
	public User load(int id) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		User user = null;
		
		try {
			con = DBUtil.getConnection();
			String sql = "select * from t_user where id=?";
			
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			
			while(rs.next()){
				user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setNickname(rs.getString("nickname"));
				user.setStatus(rs.getInt("status"));
				user.setType(rs.getInt("type"));
			}
	
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs);
			DBUtil.close(ps);
			DBUtil.close(con);
		}
	
		return user;
	}

	@Override
	public Pager<User> list(String condition) {
		//System.out.println(SystemContext.getPageIndex());
//		int pageIndex = SystemContext.getPageIndex();
		int pageOffset = SystemContext.getPageOffset();
		int pageSize = SystemContext.getPageSize();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<User> users = new ArrayList<User>();
		Pager<User> pagers = new Pager<User>();
		User user = null;
		
		try {
			
			con = DBUtil.getConnection();
			String sql = "select * from t_user";
			String sqlCount = "select count(*) from t_user";
			
			if (condition != null || !"".equals(condition)){
				sql += " where username like '%"+condition+"%' or nickname like '%"+condition+"%'";
				sqlCount += " where username like '%"+condition+"%' or nickname like '%"+condition+"%'";
			}
			sql += " limit ?, ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, pageOffset);
			ps.setInt(2, pageSize);
//			if (condition == null || "".equals(condition.trim())){
//				sql += "limit ?,?";
//				ps = con.prepareStatement(sql);
//				ps.setInt(1, start);
//				ps.setInt(2, pageSize);
//			} else {
//				sql += " where username like ? or nickname like ?";
//				ps = con.prepareStatement(sql);
//				ps.setString(1, "%"+condition+"%");
//				ps.setString(2, "%"+condition+"%");
//			}
			
			rs = ps.executeQuery();
			
			while(rs.next()){
				user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setNickname(rs.getString("nickname"));
				user.setStatus(rs.getInt("status"));
				user.setType(rs.getInt("type"));
				users.add(user);
			}
			ps = con.prepareStatement(sqlCount);
			rs = ps.executeQuery();
			int totalRecord = 0;
			while(rs.next()) {
				totalRecord = rs.getInt(1);
			}
			
			int totalPage = (totalRecord-1)/pageSize+1;
			//pagers.setPageIndex(pageIndex);
			pagers.setPageOffset(pageOffset);
			pagers.setPageSize(pageSize);
			pagers.setTotalPage(totalPage);
			pagers.setTotalRecord(totalRecord);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs);
			DBUtil.close(ps);
			DBUtil.close(con);
		}
		pagers.setDatas(users);
		return pagers;
	}

	@Override
	public User login(String username, String password) {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		User user = null;
		
		try {
			con = DBUtil.getConnection();
			String sql = "select * from t_user where username=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, username);
			rs=ps.executeQuery();
			while(rs.next()){
				user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setNickname(rs.getString("nickname"));	
				user.setStatus(rs.getInt("status"));
				user.setType(rs.getInt("type"));
			}
			if (user == null) throw new MsgException("用户名不存在");
			if (!user.getPassword().equals(password)) throw new MsgException("用户密码不正确");
			if (user.getStatus() == 1) throw new MsgException("用户已停用");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs);
			DBUtil.close(ps);
			DBUtil.close(con);
		}
	
		return user;
	}

}
