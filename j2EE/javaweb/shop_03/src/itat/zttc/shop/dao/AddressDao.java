package itat.zttc.shop.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import itat.zttc.shop.model.Address;
import itat.zttc.shop.model.ShopDi;
import itat.zttc.shop.model.ShopException;
import itat.zttc.shop.model.User;

public class AddressDao extends BaseDao<Address> implements IAddressDao {
	private IUserDao userDao;
	
	public IUserDao getUserDao() {
		return userDao;
	}
	
	@ShopDi
	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public void add(Address address, int userId) {
		User u = userDao.load(userId);
		if (u == null) throw new ShopException("添加用户的地址不存在");
		address.setUser(u);
		super.add(address);
	}

	@Override
	public void update(Address address) {
		super.update(address);
	}

	@Override
	public void delete(int id) {
		super.delete(Address.class, id);
	}

	@Override
	public Address load(int id) {
		return super.load(Address.class, id);
	}

	@Override
	public List<Address> list(int userId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userId", userId);
		return super.list(Address.class, params);
	}
}