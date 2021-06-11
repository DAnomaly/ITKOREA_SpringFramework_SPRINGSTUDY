package ex03_autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("command")
public class SelectListCommand {

	// field
	/* @Autowired */
	private Dao dao;
	
	// constructor
	public SelectListCommand() {}
	/*
	@Autowired
	public SelectListCommand(Dao dao) {
		super();
		this.dao = dao;
	}
	*/
	
	// method
	public void execute() {
		dao.selectList();
	}
	
	// getter
	public Dao getDao() {
		return dao;
	}
	// setter
	@Autowired
	@Qualifier("usedDao")
	public void setDao(Dao dao) {
		this.dao = dao;
	}
	
}
