package com.sutek.myskillsinventoryspringboot.model;

import com.fasterxml.jackson.annotation.JsonFilter;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serial;
import java.io.Serializable;

@Data
@Entity
@Table(name = "skill")
@JsonFilter("fieldFilter")
// extends Skill
public class FieldFilterSkill implements Serializable {
	@Serial
	private static final long serialVersionUID = 8798239181711053338L;

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
}
