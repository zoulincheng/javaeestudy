package itat.zttc.shop.test;


import org.junit.Test;


import itat.zttc.shop.dao.IUserDao;
import itat.zttc.shop.model.Address;
import itat.zttc.shop.model.Pager;
import itat.zttc.shop.model.ShopDi;
import itat.zttc.shop.model.SystemContext;
import itat.zttc.shop.model.User;
import itat.zttc.shop.util.DaoUtil;

public class TestUserDao extends BaseTest{
	private IUserDao ud;
	
	
	public IUserDao getUd() {
		return ud;
	}
	
	@ShopDi("userDao")
	public void setUd(IUserDao ud) {
		this.ud = ud;
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
	
	@Test
	public void testSignleten(){
		IUserDao ud1 = (IUserDao)DaoUtil.createDaoFactory().getDao("userDao");
		IUserDao ud2 = (IUserDao)DaoUtil.createDaoFactory().getDao("userDao");
		System.out.println(ud1==ud2);
	}
}
