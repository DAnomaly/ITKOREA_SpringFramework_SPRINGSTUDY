package com.koreait.mygallery.command.member;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.koreait.mygallery.command.BaseCommand;
import com.koreait.mygallery.controller.MemberController;

/**
 * MemberControler의 Command 인터페이스입니다.
 * 
 * @see MemberController
 * @see BaseCommand 
 * @author ITSC
 */
public interface MemberCommand extends BaseCommand {

	public static Logger logger = LoggerFactory.getLogger(MemberCommand.class);
	
}
