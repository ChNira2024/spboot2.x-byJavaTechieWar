package com.nt.niranjana.spboot2x.service;

import java.util.List;

import com.nt.niranjana.spboot2x.entity.EmployeeData;



public interface IEmployeeDataService {

	Integer saveEmployee(EmployeeData e);
	List<EmployeeData> getAllEmployees();
	EmployeeData getOneEmployee(Integer id);
	void deleteEmployee(Integer id);
	void updateEmployee(EmployeeData e);
}
