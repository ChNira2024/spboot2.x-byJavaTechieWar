package com.nt.niranjana.spboot2x.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nt.niranjana.spboot2x.entity.Employee;

@Repository
public interface IInsertExcelDataToDatabaseRepo extends JpaRepository<Employee, Integer> {

}
