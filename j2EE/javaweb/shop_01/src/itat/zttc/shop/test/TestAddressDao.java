package itat.zttc.shop.test;

import java.util.List;

import org.junit.Test;

import itat.zttc.shop.dao.DAOFactory;
import itat.zttc.shop.dao.IAddressDao;
import itat.zttc.shop.model.Address;

public class TestAddressDao {
	private  IAddressDao addressDao = DAOFactory.getAddressDao();
	
	@Test
	public void testLoad(){
		Address address = addressDao.load(4);
		System.out.println(address.getName() + "," + address.getUser() + "," + address.getPostcode());
	}
	
	@Test
	public void testAdd(){
		Address address = new Address();
		address.setName("广州天河棠下158号老王收");
		address.setPhone("118");
		address.setPostcode("554803");
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
