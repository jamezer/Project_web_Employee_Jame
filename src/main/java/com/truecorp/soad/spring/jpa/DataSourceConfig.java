package com.truecorp.soad.spring.jpa;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import com.truecorp.soad.spring.conf.SystemConfiguration;

@Configuration
@EnableJpaRepositories( entityManagerFactoryRef = "dsEntityManagerFactory"  ,transactionManagerRef = "dsTransactionManager" )
public class DataSourceConfig {

	@Autowired
    private Environment env;
	

	public DataSource getGatewayDatasource(){
		System.out.println("DataSourceConfig : init DataSource datasource "+env.getProperty("datasource.ds1.jdbcUrl"));
		DataSourceBuilder dsBuilder =DataSourceBuilder.create() ;
		dsBuilder.url(env.getProperty("datasource.ds1.jdbcUrl"));
		dsBuilder.username(env.getProperty("datasource.ds1.username"));
		dsBuilder.password(env.getProperty("datasource.ds1.password") );
		dsBuilder.driverClassName(env.getProperty("datasource.ds1.driverClassName"));
				return dsBuilder.build();
	}
	
	

	public DataSource jndiDatasource(){
		JndiDataSourceLookup dataSourceLookup	= new JndiDataSourceLookup();
	    DataSource dataSource= dataSourceLookup.getDataSource(env.getProperty("datasource.ds2.jndiUrl"));
	    return dataSource;	
	}
	
	
	@Bean(name="dsEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean dsEntityManagerFactory() {
		HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
		jpaVendorAdapter.setGenerateDdl(false);
		jpaVendorAdapter.setDatabasePlatform("org.hibernate.dialect.MariaDB103Dialect");
		LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
		
		if(SystemConfiguration.datasourceType .equalsIgnoreCase("direct")) {
			factoryBean.setDataSource(getGatewayDatasource());
		}else if(SystemConfiguration.datasourceType .equalsIgnoreCase("jndi")) {
			factoryBean.setDataSource(jndiDatasource());
		}
		
		factoryBean.setJpaVendorAdapter(jpaVendorAdapter);
		factoryBean.setPackagesToScan(Users.class.getPackage().getName());
		return factoryBean;
	}
	
	@Bean
	public PlatformTransactionManager dsTransactionManager() {
		return new JpaTransactionManager(dsEntityManagerFactory().getObject());
	}
}

