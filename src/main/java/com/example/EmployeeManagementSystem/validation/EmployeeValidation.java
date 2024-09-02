package com.example.EmployeeManagementSystem.validation;


import com.example.EmployeeManagementSystem.dto.EmployeeDTO;
import com.example.EmployeeManagementSystem.entity.Employee;
import com.example.EmployeeManagementSystem.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.time.Instant;

@Component
public class EmployeeValidation implements Validator {

    @Autowired
    private EmployeeRepository employeeRepository;

    public EmployeeValidation(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return EmployeeDTO.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        EmployeeDTO employeeDTO = (EmployeeDTO) target;

        if (employeeDTO.getFirstName() == null || employeeDTO.getFirstName().trim().isEmpty()) {
            errors.rejectValue("firstName", "NotBlank.employeeDTO.firstName", "İsim boş olamaz");
        }

        if (employeeDTO.getLastName() == null || employeeDTO.getLastName().trim().isEmpty()) {
            errors.rejectValue("lastName", "NotBlank.employeeDTO.lastName", "Soy isim boş olamaz");
        }

        if (employeeDTO.getPhoNumber() == null || !employeeDTO.getPhoNumber().matches("\\d{10}")) {
            errors.rejectValue("phoNumber", "Size.employeeDTO.phoNumber", "Telefon numarası 10 haneli olmalıdır");
        } else {
            if (employeeDTO.getId() != 0) {
                Employee existingEmployee = employeeRepository.findById(employeeDTO.getId()).orElse(null);
                if (existingEmployee != null && !existingEmployee.getPhoNumber().equals(employeeDTO.getPhoNumber())
                        && employeeRepository.existsByPhoNumber(employeeDTO.getPhoNumber())) {
                    errors.rejectValue("phoNumber", "Unique.employeeDTO.phoNumber", "Bu telefon numarası zaten kayıtlı.");
                }
            }
        }

        if (employeeDTO.getEmail() == null || !employeeDTO.getEmail().contains("@")) {
            errors.rejectValue("email", "Email.employeeDTO.email", "Geçerli bir e-posta adresi giriniz");
        } else {
            if (employeeDTO.getId() != 0) {
                Employee existingEmployee = employeeRepository.findById(employeeDTO.getId()).orElse(null);
                if (existingEmployee != null && !existingEmployee.getEmail().equals(employeeDTO.getEmail())
                        && employeeRepository.existsByEmail(employeeDTO.getEmail())) {
                    errors.rejectValue("email", "Unique.employeeDTO.email", "Bu e-posta adresi zaten kayıtlı.");
                }
            }
        }

        if (employeeDTO.getWorkType() == null || employeeDTO.getWorkType().trim().isEmpty()) {
            errors.rejectValue("workType", "NotNull.employeeDTO.workType", "Çalışma türü boş bırakılamaz");
        }

        if (employeeDTO.getContractType() == null || employeeDTO.getContractType().trim().isEmpty()) {
            errors.rejectValue("contractType", "NotNull.employeeDTO.contractType", "Sözleşme türü boş bırakılamaz");
        }

        if (employeeDTO.getTeam() == null || employeeDTO.getTeam().trim().isEmpty()) {
            errors.rejectValue("team", "NotNull.employeeDTO.team", "Takım boş bırakılamaz");
        }

        if (employeeDTO.getStartDate() != null && employeeDTO.getEndDate() != null &&
                employeeDTO.getEndDate().toInstant().isBefore(Instant.parse(employeeDTO.getStartDate()))) {
            errors.rejectValue("endDate", "FutureOrPresent.employeeDTO.endDate", "Bitiş tarihi başlangıç tarihinden önce olamaz");
        }
    }
}

