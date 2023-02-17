package com.example.registryactivities.controller;

import com.example.registryactivities.exception.ResourceAlreadyExistsException;
import com.example.registryactivities.model.Employee;
import com.example.registryactivities.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
@CrossOrigin(origins = "http://localhost:4200/")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<Employee> getAll() {
        return employeeService.getAll();
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody Employee employee) {
        try {
            employeeService.getEmployeeExist(employee);
            employeeService.save(employee);
            return ResponseEntity.ok(employee);
        } catch (ResourceAlreadyExistsException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }

    }

    @GetMapping("/{employeeId}")
    public Employee getById(@PathVariable Integer employeeId) {
        return employeeService.getEmployeeById(employeeId);
    }

    @PutMapping("/{employeeId}")
    public void update(@PathVariable Integer employeeId, @RequestBody Employee employee) {
        Employee existEmployee = employeeService.getEmployeeById(employeeId);
        if (existEmployee != null) {
            existEmployee.setFirstName(employee.getFirstName());
            existEmployee.setLastName(employee.getLastName());
            existEmployee.setPosition(employee.getPosition());
            employeeService.save(existEmployee);
        }
    }

    @DeleteMapping("/{employeeId}")
    public void delete(@PathVariable Integer employeeId) {
        Employee existEmployee = employeeService.getEmployeeById(employeeId);
        if (existEmployee != null) {
            employeeService.deleteEmployeeById(employeeId);
        }
    }
}
