package ex02_resource;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

/*
	@Resource
	
	1. 객체의 이름(id)이 일치하는 객체를 자동으로 주입한다.
	2. 필드, setter에 붙일 수 있다.
 */

@Component("command")
public class SelectListCommand {

	// field
	/* @Resource */
	private Dao dao;
	
	// constructor
	public SelectListCommand() {}
	public SelectListCommand(Dao dao) {
		super();
		this.dao = dao;
	}
	
	// getter
	public Dao getDao() {
		return dao;
	}
	// setter
	@Resource
	public void setDao(Dao dao) {
		this.dao = dao;
	}
	
	// method
	public void execute() {
		dao.selectList();
	}
	
}
