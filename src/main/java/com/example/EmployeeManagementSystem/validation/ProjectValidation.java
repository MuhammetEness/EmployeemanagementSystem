package com.example.EmployeeManagementSystem.validation;

import com.example.EmployeeManagementSystem.dto.ProjectDTO;
import com.example.EmployeeManagementSystem.repository.ProjetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ProjectValidation implements Validator {

    @Autowired
    private ProjetRepository projectRepository;

    public ProjectValidation(ProjetRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return ProjectDTO.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ProjectDTO projectDTO = (ProjectDTO) target;

        if (projectDTO.getProjectName() == null || projectDTO.getProjectName().trim().isEmpty()) {
            errors.rejectValue("projectName", "NotBlank.projectDTO.projectName", "Proje ismi boş olamaz");
        }

        if (projectDTO.getProjectType() == null || projectDTO.getProjectType().trim().isEmpty()) {
            errors.rejectValue("projectType", "NotBlank.projectDTO.projectType", "Proje tipi boş olamaz");
        }

        if (projectDTO.getDepartment() == null || projectDTO.getDepartment().trim().isEmpty()) {
            errors.rejectValue("department", "NotBlank.projectDTO.department", "Departman boş olamaz");
        }

        if (projectDTO.getVpnUsername() == null || projectDTO.getVpnUsername().trim().isEmpty()) {
            errors.rejectValue("vpnUsername", "NotBlank.projectDTO.vpnUsername", "VPN kullanıcı adı boş olamaz");
        }
    }
}
