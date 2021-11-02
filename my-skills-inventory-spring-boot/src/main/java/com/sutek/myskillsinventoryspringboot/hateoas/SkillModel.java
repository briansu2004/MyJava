package com.sutek.myskillsinventoryspringboot.hateoas;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.sutek.myskillsinventoryspringboot.model.Skill;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;
import org.springframework.ui.Model;

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
@JsonRootName(value = "skill")
@Relation(collectionRelation = "skills")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SkillModel extends RepresentationModel<SkillModel> {
	@Id
	@Column(name = "skill_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long skillId;

	@Column(name = "skill_name", nullable = false)
	private String skillName;

	@Column(name = "skill_name_long")
	private String skillNameLong;

	@Column(name = "skill_description")
	private String skillDescription;

	@Column(name = "status")
	private int skillStatus;

	@Column(name = "priority")
	private int skillPriority;

	private List<ProjectModel> projects;
}
