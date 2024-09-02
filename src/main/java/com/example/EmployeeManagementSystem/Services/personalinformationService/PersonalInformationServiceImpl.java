package com.example.EmployeeManagementSystem.Services.personalinformationService;


import com.example.EmployeeManagementSystem.dto.PersonalInformationDTO;
import com.example.EmployeeManagementSystem.entity.Personalinformation;
import com.example.EmployeeManagementSystem.mapper.EmployeeMapper;
import com.example.EmployeeManagementSystem.repository.PersonalInformationRepository;
import com.example.EmployeeManagementSystem.Services.personalinformationService.PersonalInformationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonalInformationServiceImpl implements PersonalInformationService {

    @Autowired
    private PersonalInformationRepository personalInformationRepository;

    @Autowired
    private EmployeeMapper mapper;

    @Override
    public List<PersonalInformationDTO> getAllPersonalInformations() {
        List<Personalinformation> personalInformations = personalInformationRepository.findAll();
        return personalInformations.stream()
                .map(mapper::toPersonalInformationDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PersonalInformationDTO getPersonalInformationById(Long id) {
        Personalinformation personalinformation = personalInformationRepository.findById(id).orElse(null);
        return mapper.toPersonalInformationDTO(personalinformation);
    }

    @Override
    public PersonalInformationDTO createPersonalInformation(PersonalInformationDTO personalInformationDTO) {
        Personalinformation personalinformation = mapper.toPersonalInformationEntity(personalInformationDTO);
        personalinformation = personalInformationRepository.save(personalinformation);
        return mapper.toPersonalInformationDTO(personalinformation);
    }

    @Override
    public PersonalInformationDTO updatePersonalInformation(Long id, PersonalInformationDTO personalInformationDTO) {
        Personalinformation existingPersonalInformation = personalInformationRepository.findById(id).orElse(null);
        if (existingPersonalInformation != null) {
            Personalinformation personalinformation = mapper.toPersonalInformationEntity(personalInformationDTO);
            personalinformation.setId(id);
            personalinformation = personalInformationRepository.save(personalinformation);
            return mapper.toPersonalInformationDTO(personalinformation);
        } else {
            return null; // Veya bir exception fırlat
        }
    }

    @Override
    public void deletePersonalInformation(Long id) {
        personalInformationRepository.deleteById(id);
    }
}
