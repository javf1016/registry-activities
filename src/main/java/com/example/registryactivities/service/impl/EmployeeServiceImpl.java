package com.example.registryactivities.service.impl;

import com.example.registryactivities.exception.ResourceNotFoundException;
import com.example.registryactivities.model.Employee;
import com.example.registryactivities.repository.EmployeeRepository;
import com.example.registryactivities.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }
    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }
    @Override
    public Employee getEmployeeById(Integer employeeId) {
        return employeeRepository.findById(employeeId).orElseThrow(() -> new ResourceNotFoundException("Employee with given Id: "+employeeId+" is not found !!!"));
    }
    @Override
    public void deleteEmployeeById(Integer employeeId) {
        employeeRepository.deleteById(employeeId);
    }
}
