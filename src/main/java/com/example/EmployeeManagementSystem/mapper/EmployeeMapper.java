package com.example.EmployeeManagementSystem.mapper;


import com.example.EmployeeManagementSystem.dto.*;
import com.example.EmployeeManagementSystem.entity.Employee;
import com.example.EmployeeManagementSystem.entity.Otherinformation;
import com.example.EmployeeManagementSystem.entity.Personalinformation;
import com.example.EmployeeManagementSystem.entity.Project;
import com.example.EmployeeManagementSystem.enums.*;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class EmployeeMapper {

    public EmployeeDTO toEmployeeDTO(Employee employee) {
        if (employee == null) {
            return null;
        }

        EmployeeDTO dto = new EmployeeDTO();
        dto.setId(employee.getId());
        dto.setFirstName(employee.getFirstName());
        dto.setLastName(employee.getLastName());
        dto.setLevel(employee.getLevel().name());
        dto.setPhoNumber(employee.getPhoNumber());
        dto.setEmail(employee.getEmail());
        dto.setBirthDate(employee.getBirtDate());
        dto.setWorkType(employee.getWorkType().name());
        dto.setContractType(employee.getContractType().name());
        dto.setStartDate(employee.getStartDate().toString());
        dto.setEndDate(employee.getEndDate());
        dto.setTeam(employee.getTeam().name());
        dto.setProjects(employee.getProjects().stream().map(this::toProjectDTO).collect(Collectors.toList()));

        if (employee.getPersonalInformation() != null) {
            dto.setPersonalinformation(toPersonalInformationDTO(employee.getPersonalInformation()));
        }
        if (employee.getOtherInformation() != null) {
            dto.setOtherInformationDTO(toOtherInformationDTO(employee.getOtherInformation()));
        }

        return dto;
    }

    public Employee toEmployeeEntity(EmployeeDTO dto) {
        if (dto == null) {
            return null;
        }

        Employee employee = new Employee();
        employee.setId(dto.getId());
        employee.setFirstName(dto.getFirstName());
        employee.setLastName(dto.getLastName());
        employee.setLevel(Levvel.valueOf(dto.getLevel()));
        employee.setPhoNumber(dto.getPhoNumber());
        employee.setEmail(dto.getEmail());
        employee.setBirtDate(dto.getBirthDate());
        employee.setWorkType(WorkType.valueOf(dto.getWorkType()));
        employee.setContractType(ContractType.valueOf(dto.getContractType()));
        employee.setStartDate(java.sql.Date.valueOf(dto.getStartDate()));
        employee.setEndDate(dto.getEndDate());
        employee.setTeam(Team.valueOf(dto.getTeam()));
        employee.setProjects(dto.getProjects().stream().map(this::toProjectEntity).collect(Collectors.toList()));

        if (dto.getPersonalinformation() != null) {
            employee.setPersonalInformation(toPersonalInformationEntity(dto.getPersonalinformation()));
        }
        if (dto.getOtherInformationDTO() != null) {
            employee.setOtherInformation(toOtherInformationEntity(dto.getOtherInformationDTO()));
        }

        return employee;
    }

    public PersonalInformationDTO toPersonalInformationDTO(Personalinformation personalinformation) {
        if (personalinformation == null) {
            return null;
        }

        PersonalInformationDTO dto = new PersonalInformationDTO();
        dto.setId(personalinformation.getId());
        dto.setBirthDate(personalinformation.getBirthDate());
        dto.setNationalId(personalinformation.getNationalId());
        dto.setMilitaryStatus(personalinformation.getMilitaryStatus().name());
        dto.setGender(personalinformation.getGender().name());
        dto.setMarriedStatus(personalinformation.getMarriedStatus().name());
        return dto;
    }

    public Personalinformation toPersonalInformationEntity(PersonalInformationDTO dto) {
        if (dto == null) {
            return null;
        }

        Personalinformation personalinformation = new Personalinformation();
        personalinformation.setId(dto.getId());
        personalinformation.setBirthDate(dto.getBirthDate());
        personalinformation.setNationalId(dto.getNationalId());
        personalinformation.setMilitaryStatus(MilitaryStatus.valueOf(dto.getMilitaryStatus()));
        personalinformation.setGender(Gender.valueOf(dto.getGender()));
        personalinformation.setMarriedStatus(MarriedStatus.valueOf(dto.getMarriedStatus()));
        return personalinformation;
    }

    private OtherInformationDTO toOtherInformationDTO(Otherinformation otherinformation) {
        if (otherinformation == null) {
            return null;
        }

        OtherInformationDTO dto = new OtherInformationDTO();
        dto.setId(otherinformation.getId());
        dto.setAddress(otherinformation.getAdress());
        dto.setBankName(otherinformation.getBankName());
        dto.setIban(otherinformation.getIban());
        dto.setEmergencyContactName(otherinformation.getEmergencyContactName());
        dto.setEmergencyContactPhoneNumber(otherinformation.getEmergencyContactPhonumber());
        return dto;
    }

    private Otherinformation toOtherInformationEntity(OtherInformationDTO dto) {
        if (dto == null) {
            return null;
        }

        Otherinformation otherinformation = new Otherinformation();
        otherinformation.setId(dto.getId());
        otherinformation.setAdress(dto.getAddress());
        otherinformation.setBankName(dto.getBankName());
        otherinformation.setIban(dto.getIban());
        otherinformation.setEmergencyContactName(dto.getEmergencyContactName());
        otherinformation.setEmergencyContactPhonumber(dto.getEmergencyContactPhoneNumber());
        return otherinformation;
    }

    public ProjectDTO toProjectDTO(Project project) {
        if (project == null) {
            return null;
        }

        ProjectDTO dto = new ProjectDTO();
        dto.setId(project.getId());
        dto.setProjectName(project.getProjectName());
        dto.setProjectType(project.getProjectType().name());  // Enum türünden String'e dönüşüm
        dto.setDepartment(project.getDepartment());
        dto.setVpnUsername(project.getVpnUsername());
        dto.setVpnPassword(project.getVpnPassword());
        dto.setEmployeeDetails(project.getEmployeeDetails());
        dto.setEmployeeIds(project.getEmployees().stream().map(Employee::getId).collect(Collectors.toList()));
        return dto;
    }

    public Project toProjectEntity(ProjectDTO dto) {
        if (dto == null) {
            return null;
        }

        Project project = new Project();
        project.setId(dto.getId());
        project.setProjectName(dto.getProjectName());
        project.setProjectType(ProjectType.valueOf(dto.getProjectType()));  // String türünden Enum'a dönüşüm
        project.setDepartment(dto.getDepartment());
        project.setVpnUsername(dto.getVpnUsername());
        project.setVpnPassword(dto.getVpnPassword());
        project.setEmployeeDetails(dto.getEmployeeDetails());
        // Employee list initialization can be added here based on ids
        return project;
    }
}
