package com.nt.niranjana.spboot2x.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeData {
	
	@Id
	@GeneratedValue
	private Integer empId;
	
	private String empName;
	private Double empSal;
	private String empDept;

}
