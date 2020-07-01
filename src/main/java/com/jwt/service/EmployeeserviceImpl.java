package com.jwt.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jwt.dao.EmployeeDAO;
import com.jwt.model.Employee;
@Service
@Transactional
public class EmployeeserviceImpl implements EmployeeService
{
@Autowired
private EmployeeDAO employeedao;
	@Override
	@Transactional
	public void addEmployee(Employee employee) 
	{
		employeedao.addEmployee(employee);
		
		
	}
	@Override
	@Transactional
	    public List<Employee> getAllEmployees() 
	 {
	        return employeedao.getAllEmployees();
	 }
	 @Override
		@Transactional
	public void deleteEmployee(Integer employeeId) {
		// TODO Auto-generated method stub
		employeedao.deleteEmployee(employeeId);
	}
	 public Employee getEmployee(int employeeid) {
	        return employeedao.getEmployee(employeeid);
	    }
	 @Override
		@Transactional
	public Employee updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeedao.updateEmployee(employee);
	}
	
	
}
