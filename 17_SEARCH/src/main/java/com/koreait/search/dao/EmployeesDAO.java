package com.koreait.search.dao;

import java.sql.SQLSyntaxErrorException;
import java.util.List;
import java.util.Map;

import com.koreait.search.dto.Employees;

public interface EmployeesDAO {

	public int countEmployees(Map<String, Object> searchMap);
	public List<Employees> selectListEmployees(Map<String, Object> searchMap);
	public List<String> indexListEmployees(String param) throws SQLSyntaxErrorException;
	
}
