package com.codegnan.service;

import java.util.List;

import com.codegnan.dao.EmployeeDao;
import com.codegnan.dao.EmployeeDaoImpl;
import com.codegnan.entity.Employee;
import com.codegnan.exceptions.InvalidEmployeeIdException;

public class EmployeeServiceImpl implements EmployeeService {
    EmployeeDao dao = new EmployeeDaoImpl();

    @Override
    public int addEmployee(Employee employee) {
        return dao.save(employee);
    }

    @Override
    public Employee getEmployeeById(int id) throws InvalidEmployeeIdException {
        return dao.findById(id);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return dao.findAll();
    }

    @Override
    public void updateEmployee(Employee employee) throws InvalidEmployeeIdException {
        dao.edit(employee);
    }

    @Override
    public void deleteEmployee(int id) throws InvalidEmployeeIdException {
        dao.delete(id);
    }
}
