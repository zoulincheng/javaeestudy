package itat.zttc.shop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import itat.zttc.shop.model.Address;
import itat.zttc.shop.model.User;
import itat.zttc.shop.util.DBUtil;

public class AddressJDBCDao implements IAddressDao {

	@Override
	public void add(Address address, int userId) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			String sql = "insert into t_address(name,phone,postcode, user_id) value (?,?,?,?)";
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, address.getName());
			ps.setString(2, address.getPhone());
			ps.setString(3, address.getPostcode());
			ps.setInt(4, userId);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(ps);
			DBUtil.close(con);
		}
	}

	@Override
	public void update(Address address) {

	}

	@Override
	public void delete(int id) {

	}



	@Override
	public List<Address> list(int userId) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet  rs = null;
		List<Address> address = new ArrayList<Address>();
		Address addr = null;
		User user = null;
		try {
//			String sql = "select * from t_address where user_id=?";
//			String sql = "select * from t_address t1 left join t_user t2 on(t1.user_id=t2.id) where user_id=?";
			String sql = "select t1.id as 'a_id',t1.name as 'a_name', t1.phone as 'phone',t1.postcode as 'postcode', "
					+ " t2.id as 'user_id',t2.nickname,t2.password,t2.username,"
					+ " t2.type as 'user_type' from t_address t1 left join t_user t2 on(t1.user_id=t2.id) where user_id=?";
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, userId);
			rs = ps.executeQuery();
			
			while(rs.next()){
				addr = new Address();
				addr.setId(rs.getInt("a_id"));
				addr.setName(rs.getString("a_name"));
				addr.setPhone(rs.getString("phone"));
				addr.setPostcode(rs.getString("postcode"));
				
				user = new User();
				user.setId(rs.getInt("user_id"));
				user.setUsername(rs.getString("username"));
				user.setNickname(rs.getString("nickname"));
				user.setPassword(rs.getString("password"));
				user.setType(rs.getInt("user_type"));
				
				addr.setUser(user);
				address.add(addr);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs);
			DBUtil.close(ps);
			DBUtil.close(con);
		}
		
		
		return address;
	}

	@Override
	public Address load(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
