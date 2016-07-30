package itat.zttc.shop.dao;

public class DAOFactory {
	public static IAddressDao getAddressDao(){
		//return new AddressJDBCDao();
		return new AddressDao();
	}

	public static IUserDao getUserDao() {
		// TODO Auto-generated method stub
		//return new UserJDBCDao();
		return new UserDao();
	}
}
