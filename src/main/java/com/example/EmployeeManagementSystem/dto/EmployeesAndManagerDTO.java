package com.example.EmployeeManagementSystem.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeesAndManagerDTO {

    @NotEmpty(message = "Employee Id gerekli")
    private List<Long> employeeIds;

    @NotNull(message = "Manager ID gerekli")
    private Long managerId;


}
