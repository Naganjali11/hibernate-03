package com.codegnan.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.codegnan.entity.Employee;
import com.codegnan.exceptions.InvalidEmployeeIdException;
import com.codegnan.helper.SessionFactoryHelper;

public class EmployeeDaoImpl implements EmployeeDao{

	@Override
	public int save(Employee employee) {
		SessionFactory sessionFactory=SessionFactoryHelper.getSessionFactory();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		int id=(int)session.save(employee);
		session.getTransaction().commit();
		session.close();
		return id;
	}

	@Override
	public List<Employee> findAll() {
		SessionFactory sessionFactory=SessionFactoryHelper.getSessionFactory();
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Employee");
		List<Employee>employees=(List<Employee>)query.getResultList();
		session.close();
		return employees;
	}

	@Override
	public Employee findById(int id) throws InvalidEmployeeIdException {
		SessionFactory sessionFactory=SessionFactoryHelper.getSessionFactory();
		Session session=sessionFactory.openSession();
		Employee employee=session.find(Employee.class, id);
		session.close();
		if(employee==null) {
			throw new InvalidEmployeeIdException("Employee id is not valid:"+id);
		}
		return employee;
	}

	@Override
	public void edit(Employee employee) throws InvalidEmployeeIdException {
		SessionFactory sessionFactory=SessionFactoryHelper.getSessionFactory();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		//step 1: Load Existing employees
		Employee existingEmployee=session.find(Employee.class, employee.getId());
		if(existingEmployee==null) {
			session.getTransaction().rollback();
			session.close();
			throw new InvalidEmployeeIdException("Cannot Update. Employee Id not found"+
		employee.getId());
		}
		//step 2: Update fields of existing employee
		existingEmployee.setName(employee.getName());
		existingEmployee.setSalary(employee.getSalary());
		existingEmployee.setDepartment(employee.getDepartment());
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public void delete(int id) throws InvalidEmployeeIdException {
		SessionFactory sessionFactory=SessionFactoryHelper.getSessionFactory();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Employee employee=session.find(Employee.class, id);
		if(employee==null) {
			throw new InvalidEmployeeIdException
			("Employee id is not a valid we cannot able to delete the record"+id);
		}session.delete(employee);
		session.getTransaction().commit();
		session.close();
	}

}
