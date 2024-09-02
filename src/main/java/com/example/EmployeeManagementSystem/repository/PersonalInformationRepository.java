package com.example.EmployeeManagementSystem.repository;

import com.example.EmployeeManagementSystem.entity.Personalinformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonalInformationRepository extends JpaRepository<Personalinformation, Long> {

}
