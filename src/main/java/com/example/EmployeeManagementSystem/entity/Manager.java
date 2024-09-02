package com.example.EmployeeManagementSystem.entity;

import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;

import java.util.List;

public class Manager {
    @OneToMany(mappedBy = "Manager", cascade = {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH})
    private List<Employee> subordinates;
}
