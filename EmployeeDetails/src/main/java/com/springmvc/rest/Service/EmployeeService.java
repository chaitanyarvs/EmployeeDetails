package com.springmvc.rest.Service;



import java.util.List;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.springmvc.rest.Model.EmployeeModel;
import com.springmvc.rest.Repos.EmployeeDao;

@Service
public class EmployeeService {
@Autowired
	private EmployeeDao DAO;

public EmployeeDao getDAO() {
	return DAO;
}

public void setDAO(EmployeeDao dAO) {
	DAO = dAO;
}
public void insertEmployeeDetails(EmployeeModel em) throws DataAccessException,HibernateException
{
	DAO.insertEmployeeDetails(em);
}
public  List<EmployeeModel> getEmployeeDetailsAll() 
{
	return DAO.getEmployeeDetailsAll();
}

public  EmployeeModel getEmployeeDetailsById(int id) 
{
	return DAO.getEmployeeDetailsById(id);
	
}
public void deleteEmployeeDetailsById(int id) 
{
	DAO.deleteEmployeeDetailsById(id);
}
}
