package com.koreait.mygallery.command.gallery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.koreait.mygallery.command.BaseCommand;
import com.koreait.mygallery.controller.GalleryController;

/**
 * GalleryController의 Command 인터페이스입니다.
 * 
 * @see GalleryController
 * @see BaseCommand 
 * @author ITSC
 */
public interface GalleryCommand extends BaseCommand {

	public static Logger logger = LoggerFactory.getLogger(GalleryCommand.class);
	
}
