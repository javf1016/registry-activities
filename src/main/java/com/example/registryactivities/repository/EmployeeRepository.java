package com.example.registryactivities.repository;

import com.example.registryactivities.enums.Position;
import com.example.registryactivities.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    @Query("SELECT e FROM Employee e WHERE e.firstName = :firstName AND e.lastName = :lastName AND e.position =:position")
    Optional<Employee> findEmployeeExist(@Param("firstName") String firstName, @Param("lastName") String lastName, @Param("position") Position position);
}
