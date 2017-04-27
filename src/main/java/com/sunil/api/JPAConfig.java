
package com.sunil.api;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EnableTransactionManagement
@PropertySource(value = "classpath:application.properties")
public class JPAConfig {
    
    @Autowired
    private Environment emv;
    
    @Bean
public LocalContainerEntityManagerFactoryBean emf(){
    LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
    emf.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
    emf.setDataSource(getDataSource());
  
    emf.setPackagesToScan("com.sunil.api.entity");
    emf.setJpaProperties(jpaProperties());
    return emf;
}

@Bean
public DataSource getDataSource(){
    DriverManagerDataSource ds = new DriverManagerDataSource();
    ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
    ds.setUrl(emv.getProperty("db.url"));
    ds.setUsername(emv.getProperty("db.username"));
    ds.setPassword(emv.getProperty("db.password"));
    
    return ds;
}
private Properties jpaProperties(){
    Properties props = new Properties();
    props.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
    props.setProperty("hibernate.hbm2ddl.auto", "create-drop");
    //System.out.println(emv.getProperty("hibernate.hbm2ddl")+"Suncjsdnvsdkjnvsdnkncndskcnsdcndskcnsdcnskcnsdn");
    props.setProperty("hibernate.show_sql", "true");
    props.setProperty("hibernate.format_sql", "true");
    return props;
}

@Bean
public PlatformTransactionManager txnMgr(EntityManagerFactory emf){
    return new JpaTransactionManager(emf);
}
    
}
