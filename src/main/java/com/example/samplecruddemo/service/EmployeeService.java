package com.example.samplecruddemo.service;

import com.example.samplecruddemo.entity.Employee;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    // same as EmployeeDAO interface
    public List<Employee> findAll();

    public Optional<Employee> findOne(int id);

    Employee save(Employee employee);

    void delete(int id);

    ResponseEntity<?> update(Employee employee, int id);
}
