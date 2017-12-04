package config;

import java.util.Properties;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

public class Oracleconfig {
	public static Logger logger = Logger.getLogger("Config");

	@Bean(name = "dataSource") // this bean available for security purpose

	public DataSource getOracleDataSource()

	{
		DriverManagerDataSource driverManagerdataSource = new DriverManagerDataSource();
		driverManagerdataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		driverManagerdataSource.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		driverManagerdataSource.setUsername("sa");
		driverManagerdataSource.setPassword("sa");

		return driverManagerdataSource;
	}

	public Properties getHibernateProperties() {
		Properties properties = new Properties();
		properties.setProperty("hibernate.hbm2ddl.auto", "update");
		properties.put("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
		return properties;
	}

	@Autowired
	@Bean(name = "sessionFactory")

	public LocalSessionFactoryBean getSessionFactory(DataSource dataSource) {
		LocalSessionFactoryBean sessionBuilder = new LocalSessionFactoryBean();
		sessionBuilder.setDataSource(getOracleDataSource());
		sessionBuilder.setHibernateProperties(getHibernateProperties());
		sessionBuilder.setPackagesToScan(new String[] { "www.com.MYSocialBack.dto" });

		return sessionBuilder;

	}

	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		return transactionManager;
	}

}
