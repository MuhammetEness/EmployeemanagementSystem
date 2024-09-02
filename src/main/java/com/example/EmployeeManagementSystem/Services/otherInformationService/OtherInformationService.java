package com.example.EmployeeManagementSystem.Services.otherInformationService;

import com.example.EmployeeManagementSystem.entity.Otherinformation;

import java.util.List;
import java.util.Optional;

public interface OtherInformationService {

    List<Otherinformation> getAllOtherInformation();

    Optional<Otherinformation> getOtherInformationById(Long id);

    Otherinformation createOtherInformation(Otherinformation otherInformation);

    Otherinformation updateOtherInformation(Long id, Otherinformation otherInformation);

    void deleteOtherInformation(Long id);
}
