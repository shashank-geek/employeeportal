package com.shashank.employeeportal.commandlinerunner;

import com.shashank.employeeportal.crud.model.Employee;
import com.shashank.employeeportal.crud.repository.EmployeeRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ApplicationStartupRunner implements CommandLineRunner
{
    protected final Log logger = LogFactory.getLog(getClass());

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public void run(String... args) throws Exception {
        logger.info("Shashank ApplicationStartupRunner run method Started !!");
        employeeRepository.save(new Employee("Shashank", "Shekhar", "Male", "1990-09-02", "Development"));
        employeeRepository.save(new Employee("Chanakaya", "Srinivas", "Male", "1991-10-18", "QA"));
        employeeRepository.save(new Employee("Neha", "somaiah", "Female", "1985-11-28", "Admin"));
        employeeRepository.save(new Employee("Soumya", "somaiah", "Female", "1989-12-05", "BA"));
        logger.info("Shashank ApplicationStartupRunner run method done !!");
    }
}
