package com.springmvc.rest.Controller;



import java.util.List;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springmvc.rest.Model.EmployeeModel;
import com.springmvc.rest.Service.EmployeeService;
@RestController
public class EmployeeController {
	
	@Autowired
private EmployeeService EService;

	public EmployeeService getEService() {
		return EService;
	}

	public void setEService(EmployeeService eService) {
		EService = eService;
	}
	
	
	
	
	@RequestMapping(value="/insertEmployeeDetails",method=RequestMethod.POST,headers="Accept=application/json")

	public void insertEmployeeDetails(@RequestBody EmployeeModel em) throws DataAccessException,HibernateException
	{
		EService.insertEmployeeDetails(em);
	}
	
	
	@RequestMapping(value="/getEmployeeDetailsAll",method=RequestMethod.GET,headers="Accept=application/json")
	public List<EmployeeModel> getEmployeeDetailsAll() 
	{
		return EService.getEmployeeDetailsAll();
	}
	
	@RequestMapping(value="/getEmployeeDetailsById/{id}",method=RequestMethod.GET,headers="Accept=application/json")
	public  EmployeeModel getEmployeeDetailsById(@PathVariable(name="id") int id) 	{
		return EService.getEmployeeDetailsById(id);
		
	}
	
	@RequestMapping(value="/deleteEmployeeDetailsById/{id}",method=RequestMethod.DELETE,headers="Accept=application/json")
	public void deleteEmployeeDetailsById(@PathVariable(name="id") int id) 	{
		EService.deleteEmployeeDetailsById(id);
	}
}
