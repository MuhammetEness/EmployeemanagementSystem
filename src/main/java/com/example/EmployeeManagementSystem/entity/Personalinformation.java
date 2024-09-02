package com.example.EmployeeManagementSystem.entity;

import com.example.EmployeeManagementSystem.enums.Gender;
import com.example.EmployeeManagementSystem.enums.MarriedStatus;
import com.example.EmployeeManagementSystem.enums.MilitaryStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;

@Entity
@Table(name = "PersonalInformation")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Personalinformation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "birth_date")
    private Date birthDate;

    @Column(name = "national_id")
    private String nationalId;

    @Enumerated(EnumType.STRING)
    @Column(name = "military_status")
    private MilitaryStatus militaryStatus;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    private Gender gender;

    @Enumerated(EnumType.STRING)
    @Column(name = "married_status")
    private MarriedStatus marriedStatus;



}
