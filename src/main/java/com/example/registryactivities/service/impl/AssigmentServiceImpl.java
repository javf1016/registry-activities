package com.example.registryactivities.service.impl;

import com.example.registryactivities.exception.ResourceNotFoundException;
import com.example.registryactivities.model.Assignment;
import com.example.registryactivities.repository.AssigmentRepository;
import com.example.registryactivities.service.AssigmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssigmentServiceImpl implements AssigmentService {
    @Autowired
    private AssigmentRepository assigmentRepository;

    @Override
    public List<Assignment> getAll() {
        return assigmentRepository.findAll();
    }

    @Override
    public void save(Assignment assignment) {
        assigmentRepository.save(assignment);
    }

    @Override
    public Assignment getAssigmentById(Integer assigmentId) {
        return assigmentRepository.findById(assigmentId).orElseThrow(() -> new ResourceNotFoundException("Assigment with given Id: "+assigmentId+" is not found !!!"));
    }

    @Override
    public void delete(Integer assigmentId) {
        assigmentRepository.deleteById(assigmentId);
    }

}