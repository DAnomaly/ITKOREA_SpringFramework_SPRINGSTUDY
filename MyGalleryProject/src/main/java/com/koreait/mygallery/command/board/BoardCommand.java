package com.koreait.mygallery.command.board;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.koreait.mygallery.command.BaseCommand;
import com.koreait.mygallery.controller.BoardController;

/**
 * BoardController의 Command 인터페이스입니다.
 * 
 * @see BoardController
 * @see BaseCommand
 * @author 박세환
 */
public interface BoardCommand extends BaseCommand {

	public static Logger logger = LoggerFactory.getLogger(BoardCommand.class);
	
}
