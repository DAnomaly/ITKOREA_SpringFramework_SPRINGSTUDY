package ex01_inject;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

/*
 	@Inject
 	
 	1. 객체의 타입(<bean class="">)이 일치하는 객체를 자동으로 주입한다.
 	2. 필드, 생성자, setter를 대상으로 한다.
 */
@Component("command")
public class SelectListCommand {

	// 1. 필드를 이용해서 주입하기
	/* @Inject */
	private Dao dao;

	// 2. 생성자를 이용해서 주입하기
	public SelectListCommand() {}
	/* 
	@Inject 
	public SelectListCommand(Dao dao) {
		super();
		this.dao = dao;
	}
	*/
	
	// 3. setter를 이용해서 주입하기
	public Dao getDao() {
		return dao;
	}
	@Inject	
	public void setDao(Dao dao) {
		this.dao = dao;
	}
	
	public void execute() {
		dao.selectList();
	}
}

