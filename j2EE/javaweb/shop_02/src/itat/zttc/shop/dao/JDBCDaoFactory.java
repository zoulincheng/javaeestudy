package itat.zttc.shop.dao;

public class JDBCDaoFactory implements IFactoryDao {
	private static IFactoryDao jdbcDaoFactory = new JDBCDaoFactory();
	private JDBCDaoFactory() {
	}
	@Override
	public IUserDao createUserDao() {
		return new UserJDBCDao();
	}

	@Override
	public IAddressDao createAddressDao() {
		return new AddressJDBCDao();
	}
	
	public static IFactoryDao getInstance(){
		return jdbcDaoFactory;
	}

}
