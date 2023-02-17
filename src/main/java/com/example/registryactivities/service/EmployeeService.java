package com.example.registryactivities.service;

import com.example.registryactivities.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {

    public List<Employee> getAll();
    public void save(Employee employee);
    public Employee getEmployeeById(Integer employeeId);
    public void deleteEmployeeById(Integer employeeId);
    public void getEmployeeExist(Employee employee);
}
