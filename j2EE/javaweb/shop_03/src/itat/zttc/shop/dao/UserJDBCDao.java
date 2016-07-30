package itat.zttc.shop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import itat.zttc.shop.model.Address;
import itat.zttc.shop.model.Pager;
import itat.zttc.shop.model.User;
import itat.zttc.shop.util.DBUtil;

public class UserJDBCDao implements IUserDao {

	private User loadSecondUser(int id){
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet  rs = null;
		List<Address> address = new ArrayList<Address>();
		Address addr = null;
		User user = null;
		
		try {
			String sql = "select *, t2.*,t2.id as 'a_id' from t_user t1 left join t_address t2 on(t1.id=t2.user_id) where t1.id=?";
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while(rs.next()){
				if (user == null){
					user = new User();
					user.setId(rs.getInt("user_id"));
					user.setNickname(rs.getString("nickname"));
					user.setPassword(rs.getString("password"));
					user.setType(rs.getInt("type"));
					user.setUsername(rs.getString("username"));
				}
				addr = new Address();
				addr.setId(rs.getInt("a_id"));
				addr.setName(rs.getString("name"));
				addr.setPhone(rs.getString("phone"));
				addr.setPostcode(rs.getString("postcode"));
				address.add(addr);
			}
			user.setAddress(address);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs);
			DBUtil.close(ps);
			DBUtil.close(con);
		}
		return user;	
	}
	
	private User loadOnceUser(int id){
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet  rs = null;
		List<Address> address = new ArrayList<Address>();
		Address addr = null;
		User user = null;
		
		try {
			String sql = "select * from t_user where id=?";
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while(rs.next()){
				user = new User();
				user.setId(rs.getInt("id"));
				user.setNickname(rs.getString("nickname"));
				user.setPassword(rs.getString("password"));
				user.setType(rs.getInt("type"));
				user.setUsername(rs.getString("username"));
			}
			sql = "select * from t_address where user_id=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while(rs.next()){
				addr = new Address();
				addr.setId(rs.getInt("id"));
				addr.setName(rs.getString("name"));
				addr.setPhone(rs.getString("phone"));
				addr.setPostcode(rs.getString("postcode"));
				address.add(addr);
			}
			user.setAddress(address);
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
	public User load(int id) {
		return loadOnceUser(id);
	}

	@Override
	public void add(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User loadByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pager<User> find(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User login(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}
}
