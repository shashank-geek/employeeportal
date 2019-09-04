package com.shashank.employeeportal.crud.api;

import com.shashank.employeeportal.crud.exception.ResourceNotFoundException;
import com.shashank.employeeportal.crud.model.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeService
{
    public List<Employee> getAllEmployees();

    public Employee getEmployeeById(Long employeeId) throws ResourceNotFoundException;

    public Employee createEmployee(Employee emp);

    public Employee updateEmployee(Long employeeId, Employee emp) throws ResourceNotFoundException;

    public Map<String, Boolean> deleteEmployee(Long employeeId) throws ResourceNotFoundException ;

    public List<Employee> getSortedEmployees(List<Employee> employeeList);
}
