package com.nt.niranjana.spboot2x.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.niranjana.spboot2x.entity.EmployeeData;
import com.nt.niranjana.spboot2x.exception.EmployeeNotFoundException;
import com.nt.niranjana.spboot2x.repo.EmployeeDataRepository;
import com.nt.niranjana.spboot2x.service.IEmployeeDataService;


@Service
public class EmployeeDataServiceImpl implements IEmployeeDataService {

	@Autowired
	private EmployeeDataRepository repo;
	
	@Override
	public Integer saveEmployee(EmployeeData e) {
		Integer id = repo.save(e).getEmpId();
		return id;
	}

	@Override
	public List<EmployeeData> getAllEmployees() {
		List<EmployeeData> listData = repo.findAll();
		return listData;
	}

	@Override
	public EmployeeData getOneEmployee(Integer id) {
		Optional<EmployeeData> opt = repo.findById(id);
	/*	
		EmployeeData empp = null;
		if(opt.isPresent())
		{
			empp = opt.get();
		}
		else {
			throw new EmployeeNotFoundException("EMPLOYEE NOT EXIST");
		}
		return empp;
		*/
		EmployeeData emp = opt.orElseThrow(()->new EmployeeNotFoundException("EMPLOYEE ID " +id+ " NOT EXIST "));
		return emp;
	}

	@Override
	public void deleteEmployee(Integer id) {
		EmployeeData empdata = getOneEmployee(id);
		repo.delete(empdata);
	}

	@Override
	public void updateEmployee(EmployeeData e) {
		repo.save(e);
	}
}
