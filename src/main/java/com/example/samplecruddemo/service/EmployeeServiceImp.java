package com.example.samplecruddemo.service;

import com.example.samplecruddemo.dao.EmployeeRepository;
import com.example.samplecruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImp implements EmployeeService {
    // define service fields.
    private EmployeeRepository employeeRepository;

    // constructor injection
    @Autowired
    public EmployeeServiceImp(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Optional<Employee> findOne(int id) {
        return employeeRepository.findById(id);
    }

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void delete(int id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public ResponseEntity<?> update(Employee employee, int id) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if (optionalEmployee.isPresent()) {
            Employee existingEmployee = optionalEmployee.get();
            existingEmployee.setFirstName(employee.getFirstName() != null ? employee.getFirstName() : existingEmployee.getFirstName());
            existingEmployee.setLastName(employee.getLastName() != null ? employee.getLastName() : existingEmployee.getLastName());
            existingEmployee.setEmail(employee.getEmail() != null ? employee.getEmail() : existingEmployee.getEmail());

            return ResponseEntity.ok(employeeRepository.save(existingEmployee));
        } else {
            String errorMessage = "No employee found with ID: " + id;
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        }
    }

}
