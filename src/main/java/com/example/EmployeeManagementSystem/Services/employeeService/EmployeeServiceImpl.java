package com.example.EmployeeManagementSystem.Services.employeeService;

import com.example.EmployeeManagementSystem.entity.Employee;
import com.example.EmployeeManagementSystem.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    @Override
    public Employee updateEmployee(Long id, Employee employee) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if (optionalEmployee.isPresent()) {
            Employee updatedEmployee = optionalEmployee.get();
            updatedEmployee.setFirstName(employee.getFirstName());
            updatedEmployee.setLastName(employee.getLastName());
            updatedEmployee.setManegerId(employee.getManegerId());
            updatedEmployee.setLevel(employee.getLevel());
            updatedEmployee.setPhoNumber(employee.getPhoNumber());
            updatedEmployee.setEmail(employee.getEmail());
            updatedEmployee.setBirtDate(employee.getBirtDate());
            updatedEmployee.setWorkType(employee.getWorkType());
            updatedEmployee.setContractType(employee.getContractType());
            updatedEmployee.setTeam(employee.getTeam());
            updatedEmployee.setStartDate(employee.getStartDate());
            updatedEmployee.setEndDate(employee.getEndDate());
            updatedEmployee.setPersonalInformation(employee.getPersonalInformation());
            updatedEmployee.setOtherInformation(employee.getOtherInformation());
            updatedEmployee.setProjects(employee.getProjects());
            return employeeRepository.save(updatedEmployee);
        } else {
            throw new RuntimeException("Employee not found with id: " + id);
        }
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}