package com.sutek.myskillsinventoryspringboot.domain;

import com.sutek.myskillsinventoryspringboot.controller.SkillController;
import com.sutek.myskillsinventoryspringboot.model.Project;
import com.sutek.myskillsinventoryspringboot.model.Skill;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class ProjectModelAssembler extends RepresentationModelAssemblerSupport<Project, ProjectModel> {
	public ProjectModelAssembler() {
		super(SkillController.class, ProjectModel.class);
	}

	@Override
	public ProjectModel toModel(Project entity) {
		ProjectModel projectModel = instantiateModel(entity);

		projectModel.add(linkTo(methodOn(SkillController.class)
			.getProjectModelById(entity.getProjectId()))
			.withSelfRel());

		projectModel.setProjectId(entity.getProjectId());
		projectModel.setProjectName(entity.getProjectName());
		projectModel.setProjectDescription(entity.getProjectDescription());
		projectModel.setProjectStatus(entity.getProjectStatus());

		projectModel.setSkills(toSkillModel(entity.getSkills()));

		return projectModel;
	}

	@Override
	public CollectionModel<ProjectModel> toCollectionModel(Iterable<? extends Project> entities) {
		CollectionModel<ProjectModel> projectModels = super.toCollectionModel(entities);

		projectModels.add(linkTo(methodOn(SkillController.class).getAllProjectModels()).withSelfRel());

		return projectModels;
	}

	private List<SkillModel> toSkillModel(List<Skill> skills) {
		if (skills.isEmpty())
			return Collections.emptyList();

		return skills.stream()
			.map(skill -> SkillModel.builder()
				.skillId(skill.getSkillId())
				.skillName(skill.getSkillName())
				.skillNameLong(skill.getSkillNameLong())
				.skillDescription(skill.getSkillDescription())
				.skillStatus(skill.getSkillStatus())
				.skillPriority(skill.getSkillPriority())
				.build()
				.add(linkTo(methodOn(SkillController.class)
					.getSkillModelById(skill.getSkillId()))
					.withSelfRel()))
			.collect(Collectors.toList());
	}
}
