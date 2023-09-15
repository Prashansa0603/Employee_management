package com.employee.management.system.Employee_Management_System.service;

import com.employee.management.system.Employee_Management_System.entity.Employee;
import com.employee.management.system.Employee_Management_System.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    public  void addEmp(Employee employee)
    {
        employeeRepository.save(employee);
    }
    public List<Employee> getAllEmp()
    {
     return    employeeRepository.findAll();
    }

    public Employee getEmpId( int id) {
        Optional<Employee> emp= employeeRepository.findById(id);
        if(emp.isPresent())
        {
            return emp.get();
        }
        return null;
    }

    public void  delete(int id)
    {
        employeeRepository.deleteById(id);
    }
}
