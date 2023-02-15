package com.example.registryactivities.repository;

import com.example.registryactivities.model.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityRepository extends JpaRepository <Activity, Integer>  {

}
