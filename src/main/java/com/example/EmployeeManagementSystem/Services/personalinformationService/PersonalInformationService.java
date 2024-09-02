package com.example.EmployeeManagementSystem.Services.personalinformationService;

import com.example.EmployeeManagementSystem.dto.PersonalInformationDTO;

import java.util.List;

public interface PersonalInformationService {

    List<PersonalInformationDTO> getAllPersonalInformations();

    PersonalInformationDTO getPersonalInformationById(Long id);

    PersonalInformationDTO createPersonalInformation(PersonalInformationDTO personalInformationDTO);

    PersonalInformationDTO updatePersonalInformation(Long id, PersonalInformationDTO personalInformationDTO);

    void deletePersonalInformation(Long id);
}
