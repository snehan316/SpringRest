package com.sneha.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sneha.springdemo.dao.EmployeeDAO;
import com.sneha.springdemo.entity.Employee;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeDAO dao;
	
	@GetMapping("/list")
	public String getEmployees(Model theModel) {
		
		List<Employee> theEmployees = dao.getEmployees();
		
		theModel.addAttribute("employees", theEmployees);
		
		return "employee-list";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		Employee theEmployee = new Employee();
		theModel.addAttribute("employee", theEmployee);
		return "employee-form";
	}
	
	@PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute("employee") Employee theEmployee) {
		
		dao.saveEmployee(theEmployee);
		return "redirect:/employee/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("empId") int theId, Model theModel) {
		Employee theEmployee = dao.getEmployee(theId);
		theModel.addAttribute("employee", theEmployee);
		return "employee-form";
	}
	
	@GetMapping("/delete")
	public String removeEmployee(@RequestParam("empId") int theId) {
		
		dao.deleteEmployee(theId);
		return "redirect:/employee/list";
	}
}
