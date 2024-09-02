package com.example.EmployeeManagementSystem.entity;

import com.example.EmployeeManagementSystem.enums.ContractType;
import com.example.EmployeeManagementSystem.enums.Levvel;
import com.example.EmployeeManagementSystem.enums.Team;
import com.example.EmployeeManagementSystem.enums.WorkType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.logging.Level;

@Entity
@Table(name = "Employees")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "maneger_id")
    private String manegerId;

    @Enumerated(EnumType.STRING)
    @Column(name = "level")
    private Levvel level;

    @Column(name = "pho_Number")
    private String phoNumber;

    @Column(name = "email")
    private String email;

    @Column(name = "birt_date")
    private Date birtDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "work_type")
    private WorkType workType;

    @Enumerated(EnumType.STRING)
    @Column(name = "contract_type")
    private ContractType contractType;

    @Column(name = "Team")
    private Team team;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @OneToOne(cascade = CascadeType.ALL)
    private Personalinformation personalInformation;

    @OneToOne(cascade = CascadeType.ALL)
    private Otherinformation otherInformation;

    @ManyToMany()
    @JoinTable(
            name = "employee_project",
            joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "project_id")
    )
    private List<Project> projects;


}
