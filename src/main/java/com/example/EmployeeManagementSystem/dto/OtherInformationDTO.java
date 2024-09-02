package com.example.EmployeeManagementSystem.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OtherInformationDTO {

    private long id;

    @NotBlank(message = "Adres gerekli")
    private String address;

    @NotBlank(message = "Banka ismi gerekli")
    private String bankName;

    @NotBlank(message = "Iban gerekli")
    private String iban;

    @NotBlank(message = "Acil durum iletişim hattı")
    private String emergencyContactName;

    @NotBlank(message = "Acil durum iletişim numarası")
    @Pattern(regexp = "^[0-9]{10}$", message = "Acil durumda ulaşılacak telefon 10 haneli olmalıdır")
    private String emergencyContactPhoneNumber;

}
