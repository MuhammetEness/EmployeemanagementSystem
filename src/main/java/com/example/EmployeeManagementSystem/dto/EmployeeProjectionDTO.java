package com.example.EmployeeManagementSystem.dto;

import com.example.EmployeeManagementSystem.entity.Otherinformation;
import com.example.EmployeeManagementSystem.entity.Personalinformation;
import lombok.*;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeProjectionDTO {

    private long id;
    private String fullName;
    private Otherinformation otherInformation;
    private Personalinformation personalInformation;


}
