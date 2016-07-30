package itat.zttc.shop.dao;

public class MysqlDaoFactory implements IFactoryDao{
	
	private static IFactoryDao mysqlFactory = new MysqlDaoFactory();
	
	private MysqlDaoFactory() {
	}
	@Override
	public IUserDao createUserDao() {
		return new UserDao();
	}

	@Override
	public IAddressDao createAddressDao() {
		return new AddressDao();
	}
	
	public static IFactoryDao getInstance(){
		return mysqlFactory;
	}
	
}
