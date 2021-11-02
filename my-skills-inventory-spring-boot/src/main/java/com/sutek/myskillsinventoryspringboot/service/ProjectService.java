package com.sutek.myskillsinventoryspringboot.service;

import com.sutek.myskillsinventoryspringboot.model.Project;

import java.util.List;

public interface ProjectService {
	List<Project> getAllProjects();
	Project getProjectById(long skillId);
	Project saveProject(Project skill);
	Project updateProject(Project skill, long skillId);
	Project patchProject(Project skill, long skillId);
	void deleteProject(long skillId);
}
