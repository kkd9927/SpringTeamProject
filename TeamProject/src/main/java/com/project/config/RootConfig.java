package com.project.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@MapperScan(basePackages = {"com.project.mapper"})
@ComponentScan(basePackages = {"com.project.service", "com.project.security"})
public class RootConfig {
	@Bean
	public DataSource dataSource() {
		HikariConfig hikariConfig = new HikariConfig();
		hikariConfig.setDriverClassName("net.sf.log4jdbc.sql.jdbcapi.DriverSpy");
		
//		<통합 테스트용>
//		hikariConfig.setJdbcUrl("jdbc:log4jdbc:oracle:thin:@10.100.206.79:1521:XE");
//		hikariConfig.setUsername("Delivery");
//		hikariConfig.setPassword("delivery");
		
//		<개인 테스트용>
		hikariConfig.setJdbcUrl("jdbc:log4jdbc:oracle:thin:@Localhost:1521:XE");
		hikariConfig.setUsername("DELIVERY_TEST");
		hikariConfig.setPassword("delivery");
		
		HikariDataSource dataSource = new HikariDataSource(hikariConfig);
		return dataSource;
	}
	
	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception {
		SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
		sqlSessionFactory.setDataSource(dataSource());
		return (SqlSessionFactory) sqlSessionFactory.getObject();
	}
}
