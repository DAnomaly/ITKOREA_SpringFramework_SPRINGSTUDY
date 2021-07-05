package com.koreait.mygallery.dao;

import java.util.List;
import java.util.Map;

import com.koreait.mygallery.dto.Gallery;
import com.koreait.mygallery.dto.GalleryCom;

public interface GalleryDAO {

	public int countGallery(Map<String, Object> map);
	public List<Gallery> selectListGallery(Map<String, Object> map);
	public int insertGallery(Gallery gallery);
	public int insertGalleryComment(GalleryCom galleryCom);
	public Gallery selectOneGallery(long no);
	public List<GalleryCom> selectGalleryComment(long no);
	public GalleryCom selectOneGalleryComment(long no);
	public int updateGallery(Gallery gallery);
	public int deleteGallery(long no);
	public int deleteGalleryCommentByGalleryNo(long no);
	public int deleteGalleryCommentByNo(long no);
	
}
