package com.shashank.employeeportal.crud.impl;

import com.shashank.employeeportal.crud.api.EmployeeService;
import com.shashank.employeeportal.crud.controller.EmployeeController;
import com.shashank.employeeportal.crud.model.Employee;
import com.shashank.employeeportal.crud.repository.EmployeeRepository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyObject;
import static org.mockito.Mockito.when;

import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeServiceImplTest
{
    @Mock
    EmployeeService employeeService;

    @Mock
    EmployeeRepository employeeRepository;

    private Employee employee = new Employee("Dexter", "Lab", "male", "05-05-1999", "Admin");

    List<Employee> employeesList = Arrays.asList(
            new Employee("Dexter", "Lab", "male", "05-05-1999", "Admin"),
            new Employee("Tom", "Jerry", "Female", "09-09-1995", "Dev"),
            new Employee("Poke", "Mon", "male", "25-05-1992", "QA"),
            new Employee("Bhim", "B", "male", "12-12-1993", "BA"));

    @Test
    public void getAllEmployees()
    {
        when(employeeRepository.findAll()).thenReturn(employeesList);
        assertEquals(4, employeesList.size());
    }

    @Test
    public void getEmployeeById()
    {
        when(employeeRepository.findById(anyLong())).thenReturn(Optional.ofNullable(employee));
        assertEquals("Dexter", employee.getFirstName());
    }

    @Test
    public void createEmployee()
    {
        when(employeeService.createEmployee(anyObject())).thenReturn(employee);
        assertEquals(employee.getFirstName(), employeeService.createEmployee(employee).getFirstName());
    }
}
