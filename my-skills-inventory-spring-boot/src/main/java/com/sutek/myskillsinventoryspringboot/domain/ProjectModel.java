package com.sutek.myskillsinventoryspringboot.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@JsonRootName(value = "project")
@Relation(collectionRelation = "projects")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProjectModel extends RepresentationModel<ProjectModel> {

	@Id
	@Column(name = "project_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long projectId;

	@Column(name = "project_name", nullable = false)
	private String projectName;

	@Column(name = "project_description")
	private String projectDescription;

	@Column(name = "status")
	private int projectStatus;

	private List<SkillModel> skills;
}
