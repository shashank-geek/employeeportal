package com.shashank.employeeportal.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shashank.employeeportal.crud.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>
{
}
