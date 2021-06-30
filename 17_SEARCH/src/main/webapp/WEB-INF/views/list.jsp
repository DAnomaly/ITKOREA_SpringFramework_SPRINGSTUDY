<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>사원 조회</title>
</head>
<body>
	<h1>사원 조회</h1>
	<table>
		<thead>
			<tr>
				<td>EMPLOYEE_ID</td>
				<td>FIRST_NAME</td>
				<td>LAST_NAME</td>
				<td>EMAIL</td>
				<td>PHONE_NUMBER</td>
				<td>HIRE_DATE</td>
				<td>JOB_ID</td>
				<td>SALARY</td>
				<td>COMMISSION_PCT</td>
				<td>MANAGER_ID</td>
				<td>DEPARTMENT_ID</td>
			</tr>
		</thead>
		<tbody>
			<c:if test="${empty list}">
			<tr>
				<td colspan="11">조회된 사원이 없습니다.</td>
			</tr>
			</c:if>
			<c:forEach items="${list}" var="emp">
			<tr>
				<td>${emp.employeeId}</td>
				<td>${emp.firstName}</td>
				<td>${emp.lastName}</td>
				<td>${emp.email}</td>
				<td>${emp.phoneNumber}</td>
				<td>${emp.hireDate}</td>
				<td>${emp.jobId}</td>
				<td>${emp.salary}</td>
				<td>${emp.commisionPct}</td>
				<td>${emp.managerId}</td>
				<td>${emp.departmentId}</td>
			</tr>
			</c:forEach>
		</tbody>
		<c:if test="${not empty paging}">
		<tfoot>
			<tr>
				<td colspan="11">${paging}</td>
			</tr>
		</tfoot>
		</c:if>
	</table>
	<input type="button" value="뒤로가기" onclick="location.href='/search/?c=${param.c}&s=${param.s}'"/>
</body>
</html>