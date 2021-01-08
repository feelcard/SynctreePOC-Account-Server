package com.kbfg.framework.config;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.PhysicalNamingStrategy;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;

/**
 * <pre>
 * 파일명     : CustomPhysicalNamingStrategy.java
 * 프로젝트  : OJTForum
 * 날짜        : 2020. 9. 17.
 * ========================================================================================
 * 			날짜	      		|    	작성자		 	|			      내  용		              | 	  
 * ========================================================================================
 * 	     2020. 9. 17.       |	        유한솔                  	|      Entity와 DB의 이름맵핑을 위한 클래스     |	
 * ========================================================================================
 * </pre>
 */

public class CustomPhysicalNamingStrategy implements PhysicalNamingStrategy {

  @Override
  public Identifier toPhysicalCatalogName(final Identifier identifier,
      final JdbcEnvironment jdbcEnv) {

    return identifier;

  }

  @Override
  public Identifier toPhysicalColumnName(final Identifier identifier,
      final JdbcEnvironment jdbcEnv) {

    return convertToSnakeCase(identifier);

  }

  @Override
  public Identifier toPhysicalSchemaName(final Identifier identifier,
      final JdbcEnvironment jdbcEnv) {

    return identifier;

  }

  @Override
  public Identifier toPhysicalSequenceName(final Identifier identifier,
      final JdbcEnvironment jdbcEnv) {

    return identifier;

  }

  @Override
  public Identifier toPhysicalTableName(final Identifier identifier,
      final JdbcEnvironment jdbcEnv) {

    return identifier;

  }

  private Identifier convertToSnakeCase(final Identifier identifier) {

    System.out.println("convertToSnakeCase is run : " + identifier.getText());

    final String regex = "([a-z])([A-Z])";

    final String replacement = "$1_$2";
    
    final String newName = identifier.getText().replaceAll(regex, replacement).toLowerCase();

    return Identifier.toIdentifier(newName);

  }

}
