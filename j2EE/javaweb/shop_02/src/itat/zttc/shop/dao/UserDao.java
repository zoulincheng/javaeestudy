package itat.zttc.shop.dao;

import java.util.HashMap;
import java.util.Map;


import itat.zttc.shop.model.Pager;
import itat.zttc.shop.model.ShopException;
import itat.zttc.shop.model.User;

public class UserDao extends BaseDao<User> implements IUserDao {

	@Override
	public void add(User user) {
		User tu = this.loadByUsername(user.getUsername());
		if (tu != null) throw new ShopException("要添加的用户已经存在");
		super.add(user);
	}

	@Override
	public void delete(int id) {
		//TODO 需要删除关联对象
		super.delete(User.class, id);
	}

	@Override
	public void update(User user) {
		super.update(user);
	}

	@Override
	public User loadByUsername(String username) {
		return super.loadBySqlId(User.class.getName() + ".load_by_username", username);
	}

	@Override
	public User load(int id) {
		return super.load(User.class, id);
	}

	@Override
	public User login(String username, String password) {
		User user = this.loadByUsername(username);
		if (user == null) {
			throw new ShopException("用户不存在 ");
		}
		if (!password.equals(user.getPassword())){
			throw new ShopException("密码错误");
		}
		
		return user;
	}
	
	@Override
	//%name%  like %name%
	public Pager<User> find(String name) {
		
		Map<String, Object> params = new HashMap<String, Object>();
		if (name != null && !name.equals("")){
			params.put("name", "%"+name+"%");
		}
		
		return super.find(User.class, params);
	}

	@Override
	public String toString() {
		return "UserDao [getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

}
