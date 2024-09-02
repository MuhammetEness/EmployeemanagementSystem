package com.example.EmployeeManagementSystem.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonalInformationDTO {

    private long id;

    @NotNull(message = "Dogum tarihi bos olamaz")
    @Past(message = "Dogum tarihi gecmis zamanda olmalıdır")
    private Date birthDate;

    @NotBlank(message = "Kimlik gerekli")
    @Pattern(regexp = "^[0-9]{11}$", message = "Kimlik numarası 11 haneli olmalıdır")
    private String nationalId;

    @NotBlank(message = "Askerlik durumu gerekli")
    private String militaryStatus;

    @NotBlank(message = "Cinsiyet gerekli")
    private String gender;

    @NotBlank(message = "Medeni hali gerekli")
    private String MarriedStatus;

}
