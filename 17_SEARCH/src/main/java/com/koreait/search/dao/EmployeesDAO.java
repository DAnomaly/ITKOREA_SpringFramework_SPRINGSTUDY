package com.koreait.search.dao;

import java.util.List;

import com.koreait.search.dto.Employees;

public interface EmployeesDAO {

	public List<Employees> selectListEmployees(int beginRecord, int endRecord);
	
}
