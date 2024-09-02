package com.example.EmployeeManagementSystem.validation;

import com.example.EmployeeManagementSystem.dto.OtherInformationDTO;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class OtherInformationValidation implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return OtherInformationDTO.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        OtherInformationDTO otherInformationDTO = (OtherInformationDTO) target;

        if (otherInformationDTO.getAddress() == null || otherInformationDTO.getAddress().trim().isEmpty()) {
            errors.rejectValue("address", "NotBlank.otherInformationDTO.address", "Adres boş olamaz");
        }

        if (otherInformationDTO.getBankName() == null || otherInformationDTO.getBankName().trim().isEmpty()) {
            errors.rejectValue("bankName", "NotBlank.otherInformationDTO.bankName", "Banka ismi boş olamaz");
        }

        if (otherInformationDTO.getIban() == null || otherInformationDTO.getIban().trim().isEmpty()) {
            errors.rejectValue("iban", "NotBlank.otherInformationDTO.iban", "IBAN boş olamaz");
        }

        if (otherInformationDTO.getEmergencyContactName() == null || otherInformationDTO.getEmergencyContactName().trim().isEmpty()) {
            errors.rejectValue("emergencyContactName", "NotBlank.otherInformationDTO.emergencyContactName", "Acil durum iletişim adı boş olamaz");
        }

        if (otherInformationDTO.getEmergencyContactPhoneNumber() == null || !otherInformationDTO.getEmergencyContactPhoneNumber().matches("\\d{10}")) {
            errors.rejectValue("emergencyContactPhoneNumber", "Size.otherInformationDTO.emergencyContactPhoneNumber", "Acil durum telefon numarası 10 haneli olmalıdır");
        }
    }
}
