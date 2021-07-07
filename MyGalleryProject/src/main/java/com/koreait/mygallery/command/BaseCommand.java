package com.koreait.mygallery.command;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

/**
 * 기본이 되는 Command입니다.<br>
 * Controller 마다 BaseCommand를 상속하는 Command인터페이스를 만들어 사용하세요.
 * 
 * @author 박세환
 */
public interface BaseCommand {

	/**
	 * sqlSession을 DB작업을 수행하고,<br>
	 * model을 통해 Controller에서 필요한 데이터를 받아와 작업을 처리합니다.<br>
	 * <br>
	 * json 데이터처리를 위해 Map&lt;String, Object&gt;를 반환하며<br>
	 * 필요로 하지 않을 경우에는 null을 반환합니다.<br>
	 * <br>
	 * &#64;ResponseBody Controller가 text/html; 형식으로 반환할 경우<br>
	 * Map&lt;String, Object&gt;에 key="response", value=[반환할 text/html;]을 put메소드를 통해 적용 뒤 반환합니다. 
	 * 
	 * @param sqlSession
	 * @param model
	 * @return
	 */
	public Map<String, Object> execute(SqlSession sqlSession, Model model);
	
}
