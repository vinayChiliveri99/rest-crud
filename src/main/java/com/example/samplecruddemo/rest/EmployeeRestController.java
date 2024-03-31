package com.example.samplecruddemo.rest;

import com.example.samplecruddemo.entity.Employee;
import com.example.samplecruddemo.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    // define fields for dao
    private EmployeeService employeeService;

    // inject employee dao using constructor injection.
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // define mappings
    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    @GetMapping("/employees/{id}")
    public Optional<Employee> findOne(@PathVariable int id) {
        return employeeService.findOne(id);
    }

    @PostMapping("/employees")
    public Employee save(@RequestBody Employee employee) {
        return employeeService.save(employee);
    }

    @DeleteMapping("/employees/{id}")
    public void delete(@PathVariable int id) {
        employeeService.delete(id);
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<?> update(@RequestBody Employee employee, @PathVariable int id) {
        return employeeService.update(employee, id);
    }
}
