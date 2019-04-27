package com.niit.CosmeticBackend.Config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.CosmeticBackend.Dao.AuthenticationDao;
import com.niit.CosmeticBackend.Dao.BillingDao;
import com.niit.CosmeticBackend.Dao.BrandDao;
import com.niit.CosmeticBackend.Dao.BrandItemsDao;
import com.niit.CosmeticBackend.Dao.CardDao;
import com.niit.CosmeticBackend.Dao.CartDao;
import com.niit.CosmeticBackend.Dao.CartItemDao;
import com.niit.CosmeticBackend.Dao.CategoryDao;
import com.niit.CosmeticBackend.Dao.OrderItemDao;
import com.niit.CosmeticBackend.Dao.OrdersDao;
import com.niit.CosmeticBackend.Dao.PayDao;
import com.niit.CosmeticBackend.Dao.ProductDao;
import com.niit.CosmeticBackend.Dao.ShippingDao;
import com.niit.CosmeticBackend.Dao.SupplierDao;
import com.niit.CosmeticBackend.Dao.UserDao;
import com.niit.CosmeticBackend.DaoImpl.AuthenticationDaoImpl;
import com.niit.CosmeticBackend.DaoImpl.BillingDaoImpl;
import com.niit.CosmeticBackend.DaoImpl.BrandDaoImpl;
import com.niit.CosmeticBackend.DaoImpl.BrandItemsDaoImpl;
import com.niit.CosmeticBackend.DaoImpl.CardDaoImpl;
import com.niit.CosmeticBackend.DaoImpl.CartDaoImpl;
import com.niit.CosmeticBackend.DaoImpl.CartItemDaoImpl;
import com.niit.CosmeticBackend.DaoImpl.CategoryDaoImpl;
import com.niit.CosmeticBackend.DaoImpl.OrderItemDaoImpl;
import com.niit.CosmeticBackend.DaoImpl.OrdersDaoImpl;
import com.niit.CosmeticBackend.DaoImpl.PayDaoImpl;
import com.niit.CosmeticBackend.DaoImpl.ProductDaoImpl;
import com.niit.CosmeticBackend.DaoImpl.ShippingDaoImpl;
import com.niit.CosmeticBackend.DaoImpl.SupplierDaoImpl;
import com.niit.CosmeticBackend.DaoImpl.UserDaoImpl;
import com.niit.CosmeticBackend.Model.Authentication;
import com.niit.CosmeticBackend.Model.Billing;
import com.niit.CosmeticBackend.Model.Brand;
import com.niit.CosmeticBackend.Model.BrandItems;
import com.niit.CosmeticBackend.Model.Card;
import com.niit.CosmeticBackend.Model.Cart;
import com.niit.CosmeticBackend.Model.CartItem;
import com.niit.CosmeticBackend.Model.Category;
import com.niit.CosmeticBackend.Model.OrderItem;
import com.niit.CosmeticBackend.Model.Orders;
import com.niit.CosmeticBackend.Model.Pay;
import com.niit.CosmeticBackend.Model.Product;
import com.niit.CosmeticBackend.Model.Shipping;
import com.niit.CosmeticBackend.Model.Supplier;
import com.niit.CosmeticBackend.Model.User;

@Configuration
@ComponentScan("com.niit.*")
@EnableTransactionManagement

public class ApplicationContext {


	@Bean("dataSource")
	public DataSource getDataSource() 
	{
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/test/project");
		dataSource.setUsername("lakshmi");
		dataSource.setPassword("database");

		return dataSource;
	}

	private Properties getHibernateProperties()
	{
		Properties properties = new Properties();
		properties.put("hibernate.connection.pool_size", "10");
		properties.put("hibernate.hbm2ddl.auto", "update");
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		return properties;
	}

	@Autowired
	@Bean("sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource) 
	{
		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
		sessionBuilder.addProperties(getHibernateProperties());
		
		sessionBuilder.addAnnotatedClass(Category.class);
		sessionBuilder.addAnnotatedClass(Product.class);
		sessionBuilder.addAnnotatedClass(Supplier.class);
		sessionBuilder.addAnnotatedClass(User.class);
	    sessionBuilder.addAnnotatedClass(Authentication.class);
	   sessionBuilder.addAnnotatedClass(Billing.class);
	   sessionBuilder.addAnnotatedClass(Cart.class);
	   sessionBuilder.addAnnotatedClass(CartItem.class);
	   sessionBuilder.addAnnotatedClass(Orders.class);
	   sessionBuilder.addAnnotatedClass(OrderItem.class);
	   sessionBuilder.addAnnotatedClass(Shipping.class);
	   sessionBuilder.addAnnotatedClass(Pay.class);
	   sessionBuilder.addAnnotatedClass(Brand.class);
	   sessionBuilder.addAnnotatedClass(BrandItems.class);
	   sessionBuilder.addAnnotatedClasses(Card.class);
		return sessionBuilder.buildSessionFactory();
	}

	
	@Autowired
	@Bean(name="transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory)
	{
		System.out.println("printing session factory here : "+sessionFactory);
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		System.out.println("printing transactionManager factory here : "+transactionManager);
		return transactionManager;
	}



   	@Autowired
   	@Bean("categoryDao")
   	public CategoryDao getCategoryDao(SessionFactory sessionFactory) 
   	{
   		return new CategoryDaoImpl(sessionFactory);
   	}
     
   	@Autowired
   	@Bean("productDao")
   	public ProductDao getProductDao(SessionFactory sessionFactory) 
   	{
   		return new ProductDaoImpl(sessionFactory);
   	}
     
	@Autowired
   	@Bean("supplierDao")
   	public SupplierDao getSupplierDao(SessionFactory sessionFactory) 
   	{
   		return new SupplierDaoImpl(sessionFactory);
   	}
   	
	@Autowired
   	@Bean("userDao")
   	public UserDao getUserDao(SessionFactory sessionFactory) 
   	{
   		return new UserDaoImpl(sessionFactory);
   	}

	@Autowired
	@Bean("authenticationDao")
	public  AuthenticationDao getAuthenticationDao(SessionFactory sessionFactory)
	{
		return new AuthenticationDaoImpl(sessionFactory);
	}
	
	
	@Autowired
	@Bean("billingDao")
	public BillingDao getBillingDao(SessionFactory sessionFactory)
	{
		return new BillingDaoImpl(sessionFactory);
	}
	
	@Autowired
	@Bean("cartDao")
	public CartDao getCartDao(SessionFactory sessionFactory)
	{
		return new CartDaoImpl(sessionFactory);
	}
	
	@Autowired
	@Bean("cartItemDao")
	public CartItemDao getCartItemDao(SessionFactory sessionFactory)
	{
		return new CartItemDaoImpl(sessionFactory);
	}
	
	@Autowired
	@Bean("ordersDao")
	public OrdersDao getOrdersDao(SessionFactory sessionFactory)
	{
		return new OrdersDaoImpl(sessionFactory);
	}
	
	@Autowired
	@Bean("orderItemDao")
	public OrderItemDao getOrderItemDao(SessionFactory sessionFactory)
	{
		return new OrderItemDaoImpl(sessionFactory);
	}
	
	@Autowired
	@Bean("shippingDao")
	public ShippingDao getShippingDao(SessionFactory sessionFactory)
	{
		return new ShippingDaoImpl(sessionFactory);
	}
	
	@Autowired
	@Bean("payDao")
	public PayDao getPayDao(SessionFactory sessionFactory)
	{
		return new PayDaoImpl(sessionFactory); 
	}
	
	@Autowired
	@Bean("brandDao")
	public BrandDao getBrandDao(SessionFactory sessionFactory)
	{
		return new BrandDaoImpl(sessionFactory); 
	}
	
	
	@Autowired
	@Bean("brandItemsDao")
	public BrandItemsDao getBrandItemsDao(SessionFactory sessionFactory)
	{
		return new BrandItemsDaoImpl(sessionFactory); 
	}
	@Autowired
	@Bean("cardDao")
	public CardDao getCardDao(SessionFactory sessionFactory)
	{
		return new CardDaoImpl(sessionFactory); 
	}
}
