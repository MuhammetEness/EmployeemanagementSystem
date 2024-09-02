package com.example.EmployeeManagementSystem.Controller;

import com.example.EmployeeManagementSystem.dto.PersonalInformationDTO;
import com.example.EmployeeManagementSystem.Services.personalinformationService.PersonalInformationService  ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/personalInformations")
public class PersonalInformationController {

    @Autowired
    private PersonalInformationService personalInformationService;

    @GetMapping
    public List<PersonalInformationDTO> getAllPersonalInformations() {
        return personalInformationService.getAllPersonalInformations();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonalInformationDTO> getPersonalInformationById(@PathVariable Long id) {
        PersonalInformationDTO personalInformationDTO = personalInformationService.getPersonalInformationById(id);
        if (personalInformationDTO != null) {
            return ResponseEntity.ok(personalInformationDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public PersonalInformationDTO createPersonalInformation(@RequestBody PersonalInformationDTO personalInformationDTO) {
        return personalInformationService.createPersonalInformation(personalInformationDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PersonalInformationDTO> updatePersonalInformation(@PathVariable Long id, @RequestBody PersonalInformationDTO personalInformationDTO) {
        PersonalInformationDTO updatedPersonalInformation = personalInformationService.updatePersonalInformation(id, personalInformationDTO);
        if (updatedPersonalInformation != null) {
            return ResponseEntity.ok(updatedPersonalInformation);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePersonalInformation(@PathVariable Long id) {
        personalInformationService.deletePersonalInformation(id);
        return ResponseEntity.noContent().build();
    }
}

