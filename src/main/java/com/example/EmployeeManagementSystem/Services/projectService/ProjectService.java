package com.example.EmployeeManagementSystem.Services.projectService;

import com.example.EmployeeManagementSystem.dto.ProjectDTO;
import java.util.List;

public interface ProjectService {

    ProjectDTO createProject(ProjectDTO projectDTO);

    ProjectDTO updateProject(Long id, ProjectDTO projectDTO);

    ProjectDTO getProjectById(Long id);

    List<ProjectDTO> getAllProjects();

    void deleteProject(Long id);
}
