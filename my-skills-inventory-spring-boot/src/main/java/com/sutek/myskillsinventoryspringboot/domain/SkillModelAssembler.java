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
public class SkillModelAssembler extends RepresentationModelAssemblerSupport<Skill, SkillModel> {

	public SkillModelAssembler() {
		super(SkillController.class, SkillModel.class);
	}

	@Override
	public SkillModel toModel(Skill entity) {
		SkillModel skillModel = instantiateModel(entity);

		skillModel.add(linkTo(methodOn(SkillController.class)
			.getProjectModelById(entity.getSkillId()))
			.withSelfRel());

		skillModel.setSkillId(entity.getSkillId());
		skillModel.setSkillName(entity.getSkillName());
		skillModel.setSkillNameLong(entity.getSkillNameLong());
		skillModel.setSkillDescription(entity.getSkillDescription());
		skillModel.setSkillStatus(entity.getSkillStatus());

		skillModel.setProjects(toProjectModel(entity.getProjects()));

		return skillModel;
	}

	@Override
	public CollectionModel<SkillModel> toCollectionModel(Iterable<? extends Skill> entities) {
		CollectionModel<SkillModel> projectModels = super.toCollectionModel(entities);

		projectModels.add(linkTo(methodOn(SkillController.class).getAllSkillModels()).withSelfRel());

		return projectModels;
	}

	private List<ProjectModel> toProjectModel(List<Project> projects) {
		if (projects.isEmpty())
			return Collections.emptyList();

		return projects.stream()
			.map(project -> ProjectModel.builder()
				.projectId(project.getProjectId())
				.projectName(project.getProjectName())
				.projectDescription(project.getProjectDescription())
				.projectStatus(project.getProjectStatus())
				.build()
				.add(linkTo(methodOn(SkillController.class)
					.getProjectModelById(project.getProjectId()))
					.withSelfRel()))
			.collect(Collectors.toList());
	}
}
