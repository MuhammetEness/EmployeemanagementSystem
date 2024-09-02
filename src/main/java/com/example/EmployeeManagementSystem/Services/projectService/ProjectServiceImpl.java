package com.example.EmployeeManagementSystem.Services.projectService;

import com.example.EmployeeManagementSystem.dto.ProjectDTO;
import com.example.EmployeeManagementSystem.entity.Project;
import com.example.EmployeeManagementSystem.enums.ProjectType;
import com.example.EmployeeManagementSystem.mapper.EmployeeMapper;
import com.example.EmployeeManagementSystem.repository.ProjetRepository;
import com.example.EmployeeManagementSystem.Services.projectService.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjetRepository projectRepository;

    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public ProjectDTO createProject(ProjectDTO projectDTO) {
        Project project = employeeMapper.toProjectEntity(projectDTO);
        project = projectRepository.save(project);
        return employeeMapper.toProjectDTO(project);
    }

    @Override
    public ProjectDTO updateProject(Long id, ProjectDTO projectDTO) {
        Project project = projectRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Project not found"));

        project.setProjectName(projectDTO.getProjectName());
        project.setProjectType(ProjectType.valueOf(projectDTO.getProjectType()));
        project.setDepartment(projectDTO.getDepartment());
        project.setVpnUsername(projectDTO.getVpnUsername());
        project.setVpnPassword(projectDTO.getVpnPassword());
        project.setEmployeeDetails(projectDTO.getEmployeeDetails());
        project.setEmployeeIds(projectDTO.getEmployeeIds());

        project = projectRepository.save(project);
        return employeeMapper.toProjectDTO(project);
    }

    @Override
    public ProjectDTO getProjectById(Long id) {
        Project project = projectRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Project not found"));
        return employeeMapper.toProjectDTO(project);
    }

    @Override
    public List<ProjectDTO> getAllProjects() {
        List<Project> projects = projectRepository.findAll();
        return projects.stream().map(employeeMapper::toProjectDTO).collect(Collectors.toList());
    }

    @Override
    public void deleteProject(Long id) {
        if (!projectRepository.existsById(id)) {
            throw new RuntimeException("Project not found");
        }
        projectRepository.deleteById(id);
    }
}