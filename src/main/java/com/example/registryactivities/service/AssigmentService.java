package com.example.registryactivities.service;

import com.example.registryactivities.model.Assignment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AssigmentService {

    public List<Assignment> getAll();
    public void save(Assignment assignment);
    public Assignment getAssigmentById(Integer assigmentId);
    public void delete(Integer assigmentId);
}
