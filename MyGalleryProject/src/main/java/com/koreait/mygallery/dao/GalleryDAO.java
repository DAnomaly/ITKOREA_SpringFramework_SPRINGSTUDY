package com.koreait.mygallery.dao;

import java.util.List;

import com.koreait.mygallery.dto.Gallery;
import com.koreait.mygallery.dto.GalleryCom;

public interface GalleryDAO {

	public int insertGallery(Gallery gallery);
	public int insertGalleryComment(Gallery gallery);
	public Gallery selectOneGallery(long no);
	public List<GalleryCom> selectGalleryComment(long no);
	public int updateGallery(Gallery gallery);
	public int deleteGallery(long no);
	public int deleteGalleryCommentByGalleryNo(long no);
	public int deleteGalleryCommentByNo(long no);
	
}
