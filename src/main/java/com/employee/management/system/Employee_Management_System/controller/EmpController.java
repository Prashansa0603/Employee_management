package com.employee.management.system.Employee_Management_System.controller;

import com.employee.management.system.Employee_Management_System.entity.Employee;
import com.employee.management.system.Employee_Management_System.service.EmployeeService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class EmpController {
    @Autowired
    private EmployeeService employeeService;
    @GetMapping("/")
    public String home(Model model)
    {
        List<Employee> emp=employeeService.getAllEmp();
        model.addAttribute("emp",emp);
        return "index";
    }
    @GetMapping("/add_emp")
    public String addEmp()
    {
        return "Add_Emp";
    }
    @PostMapping("/register")
    public  String getAddEmp(@ModelAttribute Employee e, HttpSession session,Model model)
    {
       System.out.println("data "+ e);
       session.setAttribute("msg","Employee Added Sucessfully...");
        employeeService.addEmp(e);
        List<Employee> emp=employeeService.getAllEmp();
        model.addAttribute("emp",emp);
        return "list";
    }
@GetMapping("/edit/{id}")
    public String getId(@PathVariable int id ,Model m)
    {
     Employee  e =  employeeService.getEmpId(id);
     m.addAttribute("emp",e);
        return "edit";
    }
    @PostMapping("/update")
    public String getUpdateEmp(@ModelAttribute  Employee employee ,HttpSession session,Model model)
    {
        session.setAttribute("msg","Employee updateed Sucessfully...");
        employeeService.addEmp(employee);
        List<Employee> emp=employeeService.getAllEmp();
        model.addAttribute("emp",emp);
        return "list";
    }
    @GetMapping("/delete/{id}")
    public String deleteEmp(@PathVariable  int id,HttpSession session)
    {
        employeeService.delete(id);
        session.setAttribute("msg","Employee deleted Sucessfully...");
        return "redirect:/";
    }
}
