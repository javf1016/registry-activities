package com.example.registryactivities.model;

import com.example.registryactivities.enums.Position;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Integer employeeId;

    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private Position position;

    @OneToMany(mappedBy = "employeeId", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Activity> assignedActivities = new ArrayList<>();

}
