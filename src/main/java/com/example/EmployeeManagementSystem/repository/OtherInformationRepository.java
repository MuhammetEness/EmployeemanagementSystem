package com.example.EmployeeManagementSystem.repository;

import com.example.EmployeeManagementSystem.entity.Otherinformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OtherInformationRepository extends JpaRepository<Otherinformation,Long> {

}
