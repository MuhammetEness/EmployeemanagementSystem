package com.example.EmployeeManagementSystem.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectDTO {

    private long id;

    @NotBlank(message = "Proje ismi gerekli")
    private String projectName;

    @NotBlank(message = "Proje tipi gerekli")
    private String projectType;

    @NotBlank(message = "Departman gerekli")
    private String department;

    @NotBlank(message = "Vpn kullanıcı adı gerekli")
    private String vpnUsername;

    @NotBlank(message = "Vpn sifresi gerekli")
    private String vpnPassword;

    @NotBlank(message = "Calısan detayları gerekli")
    private String employeeDetails;

    @NotEmpty(message = "Employee IDs are required")
    private List<Long> employeeIds;

}
/*{
        "adress":"istanbul",
        "bankName":"halk",
        "iban":"456546546465654",
        "emergencyContactName":"enes",
        "emergencyContactPhonumber":"05465642921"

 */