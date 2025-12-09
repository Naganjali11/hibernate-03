package com.codegnan.dao;

import java.util.List;

import com.codegnan.entity.Employee;
import com.codegnan.exceptions.InvalidEmployeeIdException;

public interface EmployeeDao {
public int save(Employee employee);
public List<Employee>findAll();
public Employee findById(int id) throws InvalidEmployeeIdException;
public void edit(Employee employee) throws InvalidEmployeeIdException;
public void delete(int id)throws InvalidEmployeeIdException;
}
