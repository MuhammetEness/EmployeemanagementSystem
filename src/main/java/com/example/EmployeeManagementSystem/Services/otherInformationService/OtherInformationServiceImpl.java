package com.example.EmployeeManagementSystem.Services.otherInformationService;

import com.example.EmployeeManagementSystem.entity.Otherinformation;
import com.example.EmployeeManagementSystem.repository.OtherInformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OtherInformationServiceImpl implements OtherInformationService {

    @Autowired
    private OtherInformationRepository otherInformationRepository;

    @Override
    public List<Otherinformation> getAllOtherInformation() {
        return otherInformationRepository.findAll();
    }

    @Override
    public Optional<Otherinformation> getOtherInformationById(Long id) {
        return otherInformationRepository.findById(id);
    }

    @Override
    public Otherinformation createOtherInformation(Otherinformation otherInformation) {
        return otherInformationRepository.save(otherInformation);
    }

    @Override
    public Otherinformation updateOtherInformation(Long id, Otherinformation otherInformationDetails) {
        Optional<Otherinformation> optionalOtherInformation = otherInformationRepository.findById(id);
        if (optionalOtherInformation.isPresent()) {
            Otherinformation otherInformation = optionalOtherInformation.get();
            otherInformation.setAdress(otherInformationDetails.getAdress());
            otherInformation.setBankName(otherInformationDetails.getBankName());
            otherInformation.setIban(otherInformationDetails.getIban());
            otherInformation.setEmergencyContactName(otherInformationDetails.getEmergencyContactName());
            otherInformation.setEmergencyContactPhonumber(otherInformationDetails.getEmergencyContactPhonumber());
            return otherInformationRepository.save(otherInformation);
        } else {
            throw new RuntimeException("OtherInformation not found with id: " + id);
        }
    }

    @Override
    public void deleteOtherInformation(Long id) {
        otherInformationRepository.deleteById(id);
    }
}

