package com.koreait.file.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.koreait.file.command.DeleteBoardCommand;
import com.koreait.file.command.DownloadBoardCommand;
import com.koreait.file.command.InsertBoardCommand;
import com.koreait.file.command.SelectListBoardCommand;
import com.koreait.file.command.SelectOneBoardCommand;
import com.koreait.file.command.UpdateBoardCommand;

@Configuration
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
	public SqlSessionFactory sqlSessionFactory() throws Exception {
		SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
		sqlSessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:com/koreait/file/dao/*.xml"));
		sqlSessionFactory.setDataSource(dataSource());
		return sqlSessionFactory.getObject();
	}
	
	@Bean
	public SqlSessionTemplate sqlSession() throws Exception {
		return new SqlSessionTemplate(sqlSessionFactory());
	}
	
	@Bean
	public CommonsMultipartResolver multipartResolver() {
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
		multipartResolver.setDefaultEncoding("UTF-8");
		multipartResolver.setMaxUploadSize(1024 * 1024 * 10);
		return multipartResolver; 
	}
	
	/* BoardCommand */
	@Bean
	public SelectListBoardCommand selectListBoardCommand() {
		return new SelectListBoardCommand();
	}
	@Bean
	public SelectOneBoardCommand selectOneBoardCommand() {
		return new SelectOneBoardCommand();
	}
	@Bean
	public InsertBoardCommand insertBoardCommand() {
		return new InsertBoardCommand();
	}
	@Bean
	public UpdateBoardCommand updateBoardCommand() {
		return new UpdateBoardCommand();
	}
	@Bean
	public DeleteBoardCommand deleteBoardCommand() {
		return new DeleteBoardCommand();
	}
	@Bean
	public DownloadBoardCommand downloadBoardCommand() {
		return new DownloadBoardCommand();
	}
}
