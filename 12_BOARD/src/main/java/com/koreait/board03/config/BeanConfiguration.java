package com.koreait.board03.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

// @Configuration
public class BeanConfiguration {

	@Bean
	public DriverManagerDataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:xe");
		dataSource.setUsername("spring");
		dataSource.setPassword("1111");
		return dataSource;
	}
	
	@Bean
	public SqlSessionFactoryBean sqlSessionFactory() {
		SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
		Resource[] resources = new Resource[1];
		resources[0] = new ClassPathResource("com/koreait/board03/dao/*.xml");
		sqlSessionFactory.setMapperLocations(resources);
		sqlSessionFactory.setDataSource(dataSource());
		return sqlSessionFactory;
	}
	
	@Bean
	public SqlSessionTemplate sqlSession() {
		SqlSessionFactory sqlSessionFactory = null;
		try {
			sqlSessionFactory = sqlSessionFactory().getObject();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new SqlSessionTemplate(sqlSessionFactory);
	}
	
}
