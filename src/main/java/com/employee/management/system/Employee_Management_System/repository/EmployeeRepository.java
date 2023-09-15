package com.employee.management.system.Employee_Management_System.repository;

import com.employee.management.system.Employee_Management_System.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
