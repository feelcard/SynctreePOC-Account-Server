package com.kbfg.framework.config;

import java.util.Properties;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;


/**
 * <pre>
 * 파일명     : DatabaseConfig.java
 * 프로젝트  : ContentApi
 * 날짜        : 2020. 9. 15.
 * ===============================================================================
 * 			날짜	      		|    	작성자		 	|			내	용		      |	  
 * ===============================================================================
 * 	     2020. 9. 15.     	|	   kbfg196       	|           DB 설정                     |	
 * ===============================================================================
 * </pre>
 */
@Configuration
@EnableConfigurationProperties
@MapperScan(basePackages = {"com.kbfg.**.mapper"})
@ConfigurationProperties//(prefix = "spring.datasource")
public class DatabaseConfig {
  private static final Logger logger = LoggerFactory.getLogger(DatabaseConfig.class);
  @Inject
  private Environment env;
  
  @Bean(destroyMethod = "close")
  public DataSource dataSource() {
    BasicDataSource dataSource = new BasicDataSource();
    try {
      dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver"); //env.getProperty("spring.datasource.driver-class-name")
      dataSource.setUrl("jdbc:mysql://localhost:3306/bankdb?characterEncoding=UTF-8&serverTimezone=Asia/Seoul"); //env.getProperty("spring.datasource.url")
      dataSource.setUsername("bank");//env.getProperty("spring.datasource.username")
      dataSource.setPassword("bank");//env.getProperty("spring.datasource.password")
    } catch (Exception e) {
      logger.info("error" + env.getProperty("spring.datasource.driver-class-name"));
    }

    return dataSource;
  }

//  @Bean
//  public DataSourceTransactionManager dataSourcetransactionManager() {
//    return new DataSourceTransactionManager(dataSource());
//  }

  /*
   * Mybatis 설정
   */

  @Autowired
  ApplicationContext applicationContext;

  @Bean
  public SqlSessionTemplate sqlSession(SqlSessionFactory sqlSessionFactory) {
    return new SqlSessionTemplate(sqlSessionFactory);
  }
  
  /*
   * JPA Hibernate 설정
    */
  @Bean
  public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {

    return new PersistenceExceptionTranslationPostProcessor();

  }

  @Bean
  public LocalContainerEntityManagerFactoryBean entityManagerFactory() {

    LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();

    em.setDataSource(dataSource());

    em.setPackagesToScan(new String[] {"com.kbfg"});

    JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();

    em.setJpaVendorAdapter(vendorAdapter);

    Properties props = new Properties();

    props.put("hibernate.show_sql", "true");//env.getProperty("spring.hibernate.show_sql")

    props.put("hibernate.physical_naming_strategy",
       "com.kbfg.framework.config.CustomPhysicalNamingStrategy");//env.getProperty("spring.hibernate.physical_naming_strategy")
    props.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");

    em.setJpaProperties(props);

    return em;

  }

  @Bean
  public PlatformTransactionManager transactionManager() {

    JpaTransactionManager transactionManager = new JpaTransactionManager();

    transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());

    return transactionManager;

  }
 
}
