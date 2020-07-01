package com.jwt.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.jwt.model.Employee;
@Repository
public class EmployeeDaoImpl implements  EmployeeDAO
{
@Autowired
private SessionFactory sessionfactory;
	@Override
	public void addEmployee(Employee employee) 
	{
		// TODO Auto-generated method stub
		
		sessionfactory.getCurrentSession().save(employee);

		
	}
public List<Employee> getAllEmployees()
{
	return sessionfactory.getCurrentSession().createQuery("from Employee").list();
}
@Override
public void deleteEmployee(Integer employeeId) {
    Employee employee = (Employee) sessionfactory.getCurrentSession().load(
            Employee.class, employeeId);
    if (null != employee) {
        this.sessionfactory.getCurrentSession().delete(employee);
    }

}
public Employee updateEmployee(Employee employee) {
    sessionfactory.getCurrentSession().update(employee);
    return employee;
}
public Employee getEmployee(int employeeid) 
{
	// TODO Auto-generated method stub
	return (Employee) sessionfactory.getCurrentSession().get(
            Employee.class, employeeid);
}


}
