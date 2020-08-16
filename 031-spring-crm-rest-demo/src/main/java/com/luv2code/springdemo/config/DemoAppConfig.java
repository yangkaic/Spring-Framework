package com.luv2code.springdemo.config;


import java.beans.PropertyVetoException;
import java.util.Properties;


import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan(basePackages="com.luv2code.springdemo")
@PropertySource("classpath:persistence-mysql.properties")
public class DemoAppConfig {
	
	//set up variable to hold the properties
	
	@Autowired
	private Environment env;
	
	// set up a logger for diagnostics
	
	private static final Logger logger = Logger.getLogger(DemoAppConfig.class);
	
	
	// define a bean for our security datasource
	
	@Bean
	public DataSource securityDataSource() {
		
		// create connection pool
		
		ComboPooledDataSource securityDataSource = new ComboPooledDataSource();
		
		try {
			securityDataSource.setDriverClass(env.getProperty("jdbc.driver"));
			
		} catch (PropertyVetoException e) {
			
			throw new RuntimeException(e);
			
		}
		
		// for sanity's sake, let's log url and user ... just to make sure we are reading the data
		
		
		logger.info("\n\n\n");
		logger.info("\n\n\n");
		
		logger.info("BEGIN ******************************************");
		
		logger.info("===DemoAppConfig.securityDataSource()");
		
		logger.info("===jdbc.url=" + env.getProperty("jdbc.url"));
		logger.info("===jdbc.user=" + env.getProperty("jdbc.user"));
		
		
		
		
		// set DB connection props
		
		securityDataSource.setJdbcUrl(env.getProperty("jdbc.url"));
		securityDataSource.setUser(env.getProperty("jdbc.user"));
		securityDataSource.setPassword(env.getProperty("jdbc.password"));
		
		// set connection pool props
		securityDataSource.setInitialPoolSize(getIntProperty("connection.pool.initialPoolSize"));
		securityDataSource.setMinPoolSize(getIntProperty("connection.pool.minPoolSize"));
		securityDataSource.setMaxPoolSize(getIntProperty("connection.pool.maxPoolSize"));
		securityDataSource.setMaxIdleTime(getIntProperty("connection.pool.maxIdleTime"));
		logger.info("SecurityDataSource: " + securityDataSource);
		
		logger.info("END ******************************************");
		logger.info("\n\n\n");
		logger.info("\n\n\n");
		return securityDataSource;
	}

	// helper method used to convert property to int
	private int getIntProperty(String string) {
		
		String propsVal = env.getProperty(string);
		
		int intPropsVal = Integer.parseInt(propsVal);
		
		return intPropsVal;
	}

	private Properties getHibernateProperties() {
		Properties props = new Properties();
		
		props.setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
		props.setProperty("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
		
		return props;
		
	}
	
	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		
		logger.info("\n\n\n");
		logger.info("\n\n\n");
		
		logger.info("BEGIN ******************************************");
		
		logger.info("===DemoAppConfig.sessionFactory()");
		
		//create session factory
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		
		//set the properties
		sessionFactory.setDataSource(securityDataSource());
		sessionFactory.setPackagesToScan(env.getProperty("hibernate.packagesToScan"));
		sessionFactory.setHibernateProperties(getHibernateProperties());
		
		logger.info("===SessionFactory: " + sessionFactory);
		logger.info("END ******************************************");
		logger.info("\n\n\n");
		logger.info("\n\n\n");
		return sessionFactory;
	}
	
	@Bean
	@Autowired
	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
		
		HibernateTransactionManager txManager = new HibernateTransactionManager();
		txManager.setSessionFactory(sessionFactory);
		
		logger.info("\n\n\n");
		logger.info("\n\n\n");
		
		logger.info("BEGIN ******************************************");
		
		logger.info("===DemoAppConfig.transactionManager(SessionFactory sessionFactory)");
		
		logger.info("===HibernateTransactionManager: " + txManager);
		
		logger.info("END ******************************************");
		logger.info("\n\n\n");
		logger.info("\n\n\n");
		
		return txManager;
	}
}
