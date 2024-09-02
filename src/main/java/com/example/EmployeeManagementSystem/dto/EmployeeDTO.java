package com.example.EmployeeManagementSystem.dto;

import com.example.EmployeeManagementSystem.entity.Personalinformation;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {

    private long id;


    @NotBlank(message = "Isim bos bırakılamaz")
    private String firstName;

    @NotBlank(message = "Soy isim bos bırakılamaz")
    private String lastName;

    @NotBlank(message = "level bos bırakılamaz")
    private String level;

    @NotBlank(message = "Telefon numarası bos bırakılamaz")
    private String phoNumber;

    @NotBlank(message = "Email bos bırakılamaz")
    private String email;

    @NotNull(message = "Dogum günü bos bırakılamaz")
    @Past(message = "")
    private Date birthDate;

    @NotBlank(message = "Work type bos bırakılamaz")
    private String workType;

    @NotBlank(message = "Sozlesme turu bos bırakılamaz")
    private String contractType;

    @NotBlank(message = "Baslangıc tarihi bos bırakılamaz")
    private String startDate;

    @Future(message = "Bitis tarihi ileri bir zamanda olmalıdır")
    private Date endDate;

    @NotBlank(message = "Takım bos olamaz")
    private String Team;

    private List<ProjectDTO> projects;

    @NotEmpty(message = "Employee IDs are required")
    private List<Long> employeeIds;

    @NotNull(message = "Manager ID is required")
    private Long managerId;


    @Valid
    @NotNull(message = "Kisisel bilgiler bos bırakılamaz")
    private PersonalInformationDTO personalinformation;

    @Valid
    @NotNull(message = "Diğer bilgiler bos bırakılamaz")
    private OtherInformationDTO otherInformationDTO;

}
