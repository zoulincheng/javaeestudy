package itat.zttc.shop.test;

import java.util.List;

import org.junit.Test;

import itat.zttc.shop.dao.AddressDao;
import itat.zttc.shop.dao.IAddressDao;
import itat.zttc.shop.dao.IUserDao;
import itat.zttc.shop.model.Address;
import itat.zttc.shop.model.ShopDi;

public class TestAddressDao extends BaseTest{
	/**
	 * this.setUserDao()
	 * this.setAddressDao()
	 */
	private  IAddressDao addressDao;
	private IUserDao userDao;
	
	
	public IAddressDao getAddressDao() {
		return addressDao;
	}

	@ShopDi
	public void setAddressDao(IAddressDao addressDao) {
		this.addressDao = addressDao;
	}

	public IUserDao getUserDao() {
		return userDao;
	}
	
	@ShopDi
	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}
	
	
	@Test
	public void TestUserDao(){
		new AddressDao();
	}

	@Test
	public void testLoad(){
		Address address = addressDao.load(4);
		System.out.println(address.getName() + "," + address.getUser() + "," + address.getPostcode());
	}
	
	@Test
	public void testAdd(){
		Address address = new Address();
		address.setName("广州天河棠下158号老何收");
		address.setPhone("118");
		address.setPostcode("554808");
		addressDao.add(address, 1);
	}
	
	@Test
	public  void testlist(){
		List<Address> list = addressDao.list(1);
		for(Address addr : list){
			System.out.println(addr.getName() + "," + addr.getUser() + "," + addr.getPostcode());
		}
	}
}
