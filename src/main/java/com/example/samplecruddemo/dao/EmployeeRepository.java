package com.example.samplecruddemo.dao;

import com.example.samplecruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    // that's it no other code required, just implement the EmployeeRepository to use the methods from
    // JPA repository.
}
