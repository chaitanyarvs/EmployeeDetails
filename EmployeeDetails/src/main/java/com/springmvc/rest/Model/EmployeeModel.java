package com.springmvc.rest.Model;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;


@Entity
@Table(name="Employee")
@Component
public class EmployeeModel implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)

	@Column(name="eid",unique=true,nullable=false)
private int eid;
	
	@Column(name="ename",nullable=false)

private String ename;
	@Column(name="esal",nullable=false)
private double esal;
	
	
public EmployeeModel() {
	
	}
public EmployeeModel(String ename, double esal) {
		super();
		
		this.ename = ename;
		this.esal = esal;
	}
public int getEid() {
	return eid;
}
public void setEid(int eid) {
	this.eid = eid;
}
public String getEname() {
	return ename;
}
public void setEname(String ename) {
	this.ename = ename;
}
public double getEsal() {
	return esal;
}
public void setEsal(double esal) {
	this.esal = esal;
}

}
