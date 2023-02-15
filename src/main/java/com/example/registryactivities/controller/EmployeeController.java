package com.example.registryactivities.controller;

import com.example.registryactivities.model.Employee;
import com.example.registryactivities.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<Employee> getAll() {
        return employeeService.getAll();
    }

    @PostMapping
    public void save(@RequestBody Employee employee) {
        employeeService.save(employee);
    }

    @GetMapping("/{employeeId}")
    public Employee getById(@PathVariable Integer employeeId) {
        return employeeService.getEmployeeById(employeeId);
    }

    @PutMapping("/{employeeId}")
    public void update(@PathVariable Integer employeeId, @RequestBody Employee employee) {
        Employee existEmployee = employeeService.getEmployeeById(employeeId);
        if (existEmployee != null) {
            existEmployee.setName(employee.getName());
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
