package itat.zttc.shop.test;


import org.junit.Before;
import org.junit.Test;


import itat.zttc.shop.dao.DAOFactory;
import itat.zttc.shop.dao.IUserDao;
import itat.zttc.shop.model.Address;
import itat.zttc.shop.model.Pager;
import itat.zttc.shop.model.SystemContext;
import itat.zttc.shop.model.User;

public class TestUserDao {
	private IUserDao ud;
	
	@Before
	public void init(){
		ud = DAOFactory.getUserDao();
	}
	
	@Test
	public void testAdd() {
		User user = new User();
		user.setNickname("孙涛");
		user.setPassword("123");
		user.setType(1);
		user.setUsername("suntao");
		ud.add(user);
	}
	
	@Test
	public void testDelete(){
		ud.delete(9);
	}
	
	@Test
	public void testLoad(){
		User user = ud.load(1);
		for (Address address : user.getAddress()){
			System.out.println(address);
		}
	}
	
	@Test
	public void testUpdate(){
		User user = ud.load(6);
		user.setPassword("123456");
		user.setType(1);
		ud.update(user);
	}
	
	@Test
	public void testLoadByName(){
		User user = ud.loadByUsername("wukong");
		System.out.println(user.getNickname());
	}

	@Test 
	public void testLogin(){
		User user = ud.login("wukong", "123456");
		System.out.println(user.getNickname());
	}
	
	@Test
	public void testFind(){
		SystemContext.setPageSize(15);
		SystemContext.setPageOffset(0);
//		SystemContext.setOrder("desc");
//		SystemContext.setSort("id");
		Pager<User> pages = ud.find(null);
		
		System.out.println(pages.getTotalRecord());
		
		for (User user : pages.getDatas()){
			System.out.println(user);
		}
	}
}
