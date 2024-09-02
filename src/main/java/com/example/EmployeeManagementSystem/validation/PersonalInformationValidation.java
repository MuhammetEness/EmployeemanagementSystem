package com.example.EmployeeManagementSystem.validation;

import com.example.EmployeeManagementSystem.dto.PersonalInformationDTO;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class PersonalInformationValidation implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return PersonalInformationDTO.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        PersonalInformationDTO personalInformationDTO = (PersonalInformationDTO) target;

        if (personalInformationDTO.getBirthDate() == null) {
            errors.rejectValue("birthDate", "NotNull.personalInformationDTO.birthDate", "Doğum tarihi boş olamaz");
        }

        if (personalInformationDTO.getNationalId() == null || !personalInformationDTO.getNationalId().matches("\\d{11}")) {
            errors.rejectValue("nationalId", "Size.personalInformationDTO.nationalId", "Kimlik numarası 11 haneli olmalıdır");
        }

        if (personalInformationDTO.getMilitaryStatus() == null || personalInformationDTO.getMilitaryStatus().trim().isEmpty()) {
            errors.rejectValue("militaryStatus", "NotBlank.personalInformationDTO.militaryStatus", "Askerlik durumu boş bırakılamaz");
        }

        if (personalInformationDTO.getGender() == null || personalInformationDTO.getGender().trim().isEmpty()) {
            errors.rejectValue("gender", "NotBlank.personalInformationDTO.gender", "Cinsiyet boş bırakılamaz");
        }

        if (personalInformationDTO.getMarriedStatus() == null || personalInformationDTO.getMarriedStatus().trim().isEmpty()) {
            errors.rejectValue("marriedStatus", "NotBlank.personalInformationDTO.marriedStatus", "Medeni hal boş bırakılamaz");
        }
    }
}
