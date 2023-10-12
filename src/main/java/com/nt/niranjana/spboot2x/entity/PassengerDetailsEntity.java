package com.nt.niranjana.spboot2x.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

import io.swagger.annotations.ApiModelProperty;

@Entity
@ApiObject
public class PassengerDetailsEntity 
{
	@Id
	@GeneratedValue
	@ApiModelProperty(value="ID is generated automatically")
	@ApiObjectField(name="Passenger ID",description="ID is generated automatically")
	private int pid;
	
	@ApiModelProperty(value="Passenger First Name")
	@ApiObjectField(name="Passenger First Name",description="enter passenger first name")
	private String pfName;
	
	@ApiModelProperty(value="Passenger Last Name")
	@ApiObjectField(name="Passenger Last Name",description="enter passenger last name")
	private String plname;
	
	@ApiModelProperty(value="Passenger From")
	@ApiObjectField(name="Passenger From",description="passenger source from")
	private String pFrom;
	
	@ApiModelProperty(value="Passenger To")
	@ApiObjectField(name="Passenger To",description="passenger destination to")
	private String pTo;
	
	@ApiModelProperty(value="Passenger Date of Journey")
	@ApiObjectField(name="Passenger Journey Date",description="passenger date of journey")
	private String pjourneyDate;
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPfName() {
		return pfName;
	}
	public void setPfName(String pfName) {
		this.pfName = pfName;
	}
	public String getPlname() {
		return plname;
	}
	public void setPlname(String plname) {
		this.plname = plname;
	}
	public String getpFrom() {
		return pFrom;
	}
	public void setpFrom(String pFrom) {
		this.pFrom = pFrom;
	}
	public String getpTo() {
		return pTo;
	}
	public void setpTo(String pTo) {
		this.pTo = pTo;
	}
	public String getPjourneyDate() {
		return pjourneyDate;
	}
	public void setPjourneyDate(String pjourneyDate) {
		this.pjourneyDate = pjourneyDate;
	}
	public PassengerDetailsEntity(int pid, String pfName, String plname, String pFrom, String pTo,
			String pjourneyDate) {
		super();
		this.pid = pid;
		this.pfName = pfName;
		this.plname = plname;
		this.pFrom = pFrom;
		this.pTo = pTo;
		this.pjourneyDate = pjourneyDate;
	}
	public PassengerDetailsEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "PassengerDetailsEntity [pid=" + pid + ", pfName=" + pfName + ", plname=" + plname + ", pFrom=" + pFrom
				+ ", pTo=" + pTo + ", pjourneyDate=" + pjourneyDate + "]";
	}
	
	

}
