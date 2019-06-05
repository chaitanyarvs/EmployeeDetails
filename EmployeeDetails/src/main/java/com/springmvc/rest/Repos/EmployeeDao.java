package com.springmvc.rest.Repos;

import java.io.InvalidObjectException;
import java.util.InputMismatchException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springmvc.rest.Model.EmployeeModel;

@Repository
public class EmployeeDao
{
	@Autowired
private HibernateTemplate Template;

public HibernateTemplate getTemplate() {
	return Template;
}

public void setTemplate(HibernateTemplate template) {
	Template = template;
}
public  List<EmployeeModel> getEmployeeDetailsAll() 
{
	List<EmployeeModel> em=getTemplate().loadAll(EmployeeModel.class);
	return em;
}
//Insert Employee Details into table
@Transactional
public void insertEmployeeDetails(EmployeeModel em) throws DataAccessException,HibernateException

{
	try {
Session session=getTemplate().getSessionFactory().openSession();
session.beginTransaction();
getTemplate().save(em);
session.getTransaction().commit();
session.close();
	}
	catch(DataAccessException dx)
	{
		throw dx;
	}
	catch(HibernateException hx)
	{
		throw hx;
	}
	
	
}
public  EmployeeModel getEmployeeDetailsById(int id) 
{
	EmployeeModel es=getTemplate().get(EmployeeModel.class, id);
	return es;
}


public void deleteEmployeeDetailsById(int id)
{
	Session session=getTemplate().getSessionFactory().openSession();
	session.beginTransaction();
	EmployeeModel en=session.load(EmployeeModel.class, id);
	session.delete(en);
	session.getTransaction().commit();
	session.close();

}

}
