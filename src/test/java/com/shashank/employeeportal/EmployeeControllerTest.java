package com.shashank.employeeportal;


import com.shashank.employeeportal.crud.api.EmployeeService;
import com.shashank.employeeportal.crud.controller.EmployeeController;
import com.shashank.employeeportal.crud.model.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyObject;

@RunWith(SpringRunner.class)
@WebMvcTest(value = EmployeeController.class, secure = false)
public class EmployeeControllerTest
{
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeeService employeeService;

    private Employee employee = new Employee("Dexter", "Lab", "male", "05-05-1999", "Admin");

    List<Employee> employeesList = Arrays.asList(
            new Employee("Dexter", "Lab", "male", "05-05-1999", "Admin"),
            new Employee("Tom", "Jerry", "Female", "09-09-1995", "Dev"),
            new Employee("Poke", "Mon", "male", "25-05-1992", "QA"),
            new Employee("Bhim", "B", "male", "12-12-1993", "BA"));

    @Test
    public void getAllEmployees() throws Exception
    {
        Mockito.when(employeeService.getAllEmployees()).thenReturn(employeesList);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                "/api/v1/employees").accept(
                MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        String expected = "[\n" +
                "    {\n" +
                "        \"id\": 0,\n" +
                "        \"firstName\": \"Dexter\",\n" +
                "        \"lastName\": \"Lab\",\n" +
                "        \"gender\": \"male\",\n" +
                "        \"dob\": \"05-05-1999\",\n" +
                "        \"department\": \"Admin\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\": 0,\n" +
                "        \"firstName\": \"Tom\",\n" +
                "        \"lastName\": \"Jerry\",\n" +
                "        \"gender\": \"Female\",\n" +
                "        \"dob\": \"09-09-1995\",\n" +
                "        \"department\": \"Dev\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\": 0,\n" +
                "        \"firstName\": \"Poke\",\n" +
                "        \"lastName\": \"Mon\",\n" +
                "        \"gender\": \"male\",\n" +
                "        \"dob\": \"25-05-1992\",\n" +
                "        \"department\": \"QA\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\": 0,\n" +
                "        \"firstName\": \"Bhim\",\n" +
                "        \"lastName\": \"B\",\n" +
                "        \"gender\": \"male\",\n" +
                "        \"dob\": \"12-12-1993\",\n" +
                "        \"department\": \"BA\"\n" +
                "    }\n" +
                "]";
        System.out.println(result.getResponse());

        JSONAssert.assertEquals(expected, result.getResponse()
                .getContentAsString(), false);
    }

    @Test
    public void createEmployee() throws Exception
    {
        Mockito.when(employeeService.createEmployee(anyObject())).thenReturn(employee);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                "/api/v1/employees").accept(
                MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        MockHttpServletResponse response = result.getResponse();

        System.out.println(HttpHeaders.LOCATION);

        assertEquals(HttpStatus.OK.value(), response.getStatus());
    }
}
