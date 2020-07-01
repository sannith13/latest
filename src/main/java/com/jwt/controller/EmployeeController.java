package com.jwt.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.jwt.model.Employee;
import com.jwt.service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeservice;
	
/*@RequestMapping(value="/home", method = {RequestMethod.GET},headers="Accept=*")
	public String home1()
	{
		return "HOME";
	}*/
	
	
	@RequestMapping(value="/Employee", method = {RequestMethod.GET},headers="Accept=*/*")
	public ModelAndView home(@ModelAttribute Employee employee)
	{
		
		
		return new ModelAndView("EmployeeForm");
	}
	
	@RequestMapping(value="/saveEmployee",method = {RequestMethod.GET},headers="Accept=*/*")
	public ModelAndView saveEmployee(@Valid Employee employee,BindingResult result)
	{
		ModelAndView model=null;
	
	if(result.hasErrors()) {
		System.out.println("Erro Found");
		model=new ModelAndView("EmployeeForm");
		return model;
	}
		if(employee.getId() ==0)
		{
			employeeservice.addEmployee(employee);
			
			//ModelAndView model=new ModelAndView();
			 List<Employee> listEmployee = employeeservice.getAllEmployees();
		      ///  model.addObject("listEmployee", listEmployee);
			
			  model=new ModelAndView("Home","listEmployee",listEmployee);
			
			
			System.out.println("employee added sucessfully");
			
		}else
		{
			employeeservice.updateEmployee(employee);
			List<Employee> listEmployee = employeeservice.getAllEmployees();
		      ///  model.addObject("listEmployee", listEmployee);
			
			  model=new ModelAndView("Home","listEmployee",listEmployee);
		}
		
		return model;//new ModelAndView("Home","listEmployee",model);
	}
	@RequestMapping(value = "/deleteEmployee", method = RequestMethod.GET)
    public ModelAndView deleteEmployee(HttpServletRequest request) {
        int employeeId = Integer.parseInt(request.getParameter("id"));
        employeeservice.deleteEmployee(employeeId);
        List<Employee> listEmployee = employeeservice.getAllEmployees();
	      ///  model.addObject("listEmployee", listEmployee);
		
        ModelAndView model=new ModelAndView("Home","listEmployee",listEmployee);
		  return model;
		
    }
	@RequestMapping(value = "/editEmployee", method = RequestMethod.GET)
    public ModelAndView editContact(HttpServletRequest request) {
        int employeeId = Integer.parseInt(request.getParameter("id"));
        Employee employee = employeeservice.getEmployee(employeeId);
        ModelAndView model = new ModelAndView("EmployeeForm");
        model.addObject("employee", employee);
 
        return model;
    }
	
	
}
