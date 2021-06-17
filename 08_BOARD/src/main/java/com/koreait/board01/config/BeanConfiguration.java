package com.koreait.board01.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.koreait.board01.command.DeleteBoardCommand;
import com.koreait.board01.command.InsertBoardCommand;
import com.koreait.board01.command.ListBoardCommand;
import com.koreait.board01.command.SelectBoardCommand;
import com.koreait.board01.command.UpdateBoardCommand;

@Configuration
public class BeanConfiguration {

	@Bean
	public DeleteBoardCommand deleteBoardCommand() {
		return new DeleteBoardCommand();
	}
	
	@Bean
	public InsertBoardCommand insertBoardCommand() {
		return new InsertBoardCommand();
	}
	
	@Bean
	public ListBoardCommand listBoardCommand() {
		return new ListBoardCommand();
	}
	
	@Bean
	public SelectBoardCommand selectBoardCommand() {
		return new SelectBoardCommand();
	}
	
	@Bean
	public UpdateBoardCommand updateBoardCommand() {
		return new UpdateBoardCommand();
	}
	
}
