package com.sutek.myskillsinventoryspringboot.controller;

import com.sutek.myskillsinventoryspringboot.model.Project;
import com.sutek.myskillsinventoryspringboot.model.Skill;
import com.sutek.myskillsinventoryspringboot.service.ProjectService;
import com.sutek.myskillsinventoryspringboot.service.SkillService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/skill-inventory")
public class ProjectController {
	private final ProjectService projectService;

	public ProjectController(ProjectService projectService) {
		super();
		this.projectService = projectService;
	}

	// Get all projects
	// GET
	// http://localhost:8080/api/v1/project-inventory/projects
	@GetMapping(value = "projects1")
	public ResponseEntity<List<Project>> getAllProjects() {
		return new ResponseEntity<List<Project>>(projectService.getAllProjects(), HttpStatus.OK);
	}

	// Get one project by Id
	// GET
	// http://localhost:8080/api/v1/project-inventory/projects/1
	@GetMapping(value = "projects1/{id}")
	public ResponseEntity<Project> getProjectById(@PathVariable("id") long projectId) {
		return new ResponseEntity<Project>(projectService.getProjectById(projectId), HttpStatus.OK);
	}
}
