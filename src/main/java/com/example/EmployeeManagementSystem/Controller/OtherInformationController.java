package com.example.EmployeeManagementSystem.Controller;

import com.example.EmployeeManagementSystem.Services.otherInformationService.OtherInformationServiceImpl;
import com.example.EmployeeManagementSystem.entity.Otherinformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/otherInformation")
public class OtherInformationController {


    @Autowired
    private OtherInformationServiceImpl otherInformationServiceImpl;


    public OtherInformationController(OtherInformationServiceImpl otherInformationServiceImpl) {
        this.otherInformationServiceImpl = otherInformationServiceImpl;
    }

    @GetMapping
    public List<Otherinformation> getAllOtherInformation() {
        return otherInformationServiceImpl.getAllOtherInformation();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Otherinformation> getOtherInformationById(@PathVariable Long id) {
        Optional<Otherinformation> otherInformation = otherInformationServiceImpl.getOtherInformationById(id);
        return otherInformation.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/add")
    public Otherinformation createOtherInformation(@RequestBody Otherinformation otherInformation) {
        return otherInformationServiceImpl.createOtherInformation(otherInformation);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Otherinformation> updateOtherInformation(@PathVariable Long id, @RequestBody Otherinformation otherInformationDetails) {
        return ResponseEntity.ok(otherInformationServiceImpl.updateOtherInformation(id, otherInformationDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOtherInformation(@PathVariable Long id) {
        otherInformationServiceImpl.deleteOtherInformation(id);
        return ResponseEntity.ok().build();
    }
}
