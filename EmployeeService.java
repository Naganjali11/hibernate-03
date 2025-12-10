package com.codegnan.service;

import java.util.List;

import com.codegnan.entity.Employee;
import com.codegnan.exceptions.InvalidEmployeeIdException;

public interface EmployeeService {
public int addEmployee(Employee employee);
public Employee getEmployeeById(int id)throws InvalidEmployeeIdException;
public List<Employee>getAllEmployees();
public void updateEmployee(Employee employee)throws InvalidEmployeeIdException;
public void deleteEmployee(int id)throws InvalidEmployeeIdException;
}
