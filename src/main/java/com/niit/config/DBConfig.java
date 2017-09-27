package com.niit.config;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.dao.CartDAO;
import com.niit.dao.CartDAOImpl;
import com.niit.dao.CategoryDAO;
import com.niit.dao.CategoryDAOImpl;
import com.niit.dao.ProductDAO;
import com.niit.dao.ProductDAOImpl;
import com.niit.dao.SupplierDAO;
import com.niit.dao.SupplierDAOImpl;
import com.niit.dao.UserDAO;
import com.niit.dao.UserDAOImpl;

import com.niit.model.Cart;
import com.niit.model.Category;
import com.niit.model.Product;
import com.niit.model.Supplier;
import com.niit.model.User;

@Configuration
@ComponentScan("com.niit")
@EnableTransactionManagement
public class DBConfig 
{
	@Bean
	public SessionFactory getSessionFactory()
	{
		//DataSource Manager
		DriverManagerDataSource dataSourceManager=new DriverManagerDataSource();
		dataSourceManager.setUrl("jdbc:h2:~/test");
		dataSourceManager.setDriverClassName("org.h2.Driver");
		dataSourceManager.setUsername("sa");
		dataSourceManager.setPassword("");
		
		//Hibernate Properties
		Properties hibernateproperties=new Properties();
		hibernateproperties.setProperty("hibernate.hbm2ddl.auto", "update");
		hibernateproperties.setProperty("hibernate.dialect","org.hibernate.dialect.H2Dialect");
	
		//LocalSessionFactoryBuilder
		LocalSessionFactoryBuilder localSessionFactoryBuilder=new LocalSessionFactoryBuilder(dataSourceManager);
		localSessionFactoryBuilder.addProperties(hibernateproperties);
		localSessionFactoryBuilder.addAnnotatedClass(User.class);
		localSessionFactoryBuilder.addAnnotatedClass(Category.class);
		localSessionFactoryBuilder.addAnnotatedClass(Product.class);
		localSessionFactoryBuilder.addAnnotatedClass(Supplier.class);
		localSessionFactoryBuilder.addAnnotatedClass(Cart.class);
		System.out.println("Session Factory Created");
		return localSessionFactoryBuilder.buildSessionFactory();
		
	}
	
	@Bean
	public HibernateTransactionManager getHibernateTransaction(SessionFactory sessionFactory)
	{
		System.out.println("Hibernate Transaction Created");
		return new HibernateTransactionManager(sessionFactory);
	}

	@Bean
	public UserDAO getUserDAO(SessionFactory sessionFactory)
	{
		System.out.println("UserDAO Object Created");
		return new UserDAOImpl(sessionFactory);
	}
	
	
	 @Bean	 
	public CategoryDAO getCatergoryDAO(SessionFactory sessionFactory)
	{
		System.out.println("CategoryDAO Object Created");
		return new CategoryDAOImpl(sessionFactory);
	}

	@Bean	 
	public ProductDAO getProductDAO(SessionFactory sessionFactory)
	{
		System.out.println("ProductDAO Object Created");
		return new ProductDAOImpl(sessionFactory);
	}
	
	@Bean	 
	public SupplierDAO getSupplierDAO(SessionFactory sessionFactory)
	{
		System.out.println("SupplierDAO Object Created");
		return new SupplierDAOImpl(sessionFactory);
	}
	
	@Bean	 
	public CartDAO getCartDAO(SessionFactory sessionFactory)
	{
		System.out.println("CartDAO Object Created");
		return new CartDAOImpl(sessionFactory);
	}
	 
	
}
