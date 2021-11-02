package com.sutek.myskillsinventoryspringboot.service.impl;


import com.sutek.myskillsinventoryspringboot.exception.ResourceNotFoundException;
import com.sutek.myskillsinventoryspringboot.model.Project;
import com.sutek.myskillsinventoryspringboot.repository.ProjectRepository;
import com.sutek.myskillsinventoryspringboot.service.ProjectService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class ProjectServiceImpl implements ProjectService {

	private final ProjectRepository projectRepository;

	@Override
	@Cacheable("projects")
	public List<Project> getAllProjects() {
		return projectRepository.findAll();
	}

	@Override
	@Cacheable(cacheNames = "project", key = "#projectId")
	public Project getProjectById(long projectId) {
		return projectRepository.findById(projectId).orElseThrow(() -> new ResourceNotFoundException("Project",
			"projectId", projectId));
	}

	@Override
	public Project saveProject(Project project) {
		return projectRepository.save(project);
	}

	@Override
	@CachePut(value = "projects", key = "#project.projectId")
	public Project updateProject(Project project, long projectId) {
		// Fetch the project to be updated
		Project existingProject = projectRepository.findById(projectId).orElseThrow(() -> new ResourceNotFoundException("Project", "Id", projectId));

		// Update this project
		existingProject.setProjectName(project.getProjectName());
		existingProject.setProjectDescription(project.getProjectDescription());
		existingProject.setProjectStatus(project.getProjectStatus());

		// Save updated project to DB
		projectRepository.save(existingProject);

		return existingProject;
	}

	@Override
	@CachePut(value = "projects", key = "#project.projectId")
	public Project patchProject(Project project, long projectId) {
		// Fetch the project to be updated
		Project existingProject = projectRepository.findById(projectId).orElseThrow(() -> new ResourceNotFoundException("Project", "Id", projectId));

		// Update this project
		if (project.getProjectName() != null) {
			existingProject.setProjectName(project.getProjectName());
		}

		if (project.getProjectDescription() != null) {
			existingProject.setProjectDescription(project.getProjectDescription());
		}

		if (project.getProjectStatus() != 0) {
			existingProject.setProjectStatus(project.getProjectStatus());
		}

		// Save updated project to DB
		projectRepository.save(existingProject);

		return existingProject;
	}

	@Override
	@CacheEvict(value = "project", key = "#projectId")
	public void deleteProject(long projectId) {

	}
}
