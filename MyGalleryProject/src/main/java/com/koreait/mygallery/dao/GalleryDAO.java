package com.koreait.mygallery.dao;

import com.koreait.mygallery.dto.Gallery;

public interface GalleryDAO {

	public int insertGallery(Gallery gallery);
	public Gallery selectOneGallery(long no);
	public int updateGallery(Gallery gallery);
	
}
