package com.sutek.myskillsinventoryspringboot.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.io.Serial;
import java.io.Serializable;
import java.util.List;

/*
DROP TABLE IF EXISTS skill;

CREATE TABLE IF NOT EXISTS skill (
    skill_id INT AUTO_INCREMENT PRIMARY KEY,
    skill_name VARCHAR(255) NOT NULL,
    skill_name_long VARCHAR(1000),
    skill_description VARCHAR(2000),
    status TINYINT NOT NULL DEFAULT 0, # 0: Not yet / Learning; 1: Done;
    priority TINYINT NOT NULL DEFAULT 0, # 0: general; 1: #1 - most important; 2: #2 - less important than 1 ...
    created_dt TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
 */

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "projects")
@Table(name = "skill")
public class Skill implements Serializable {
	@Serial
	private static final long serialVersionUID = -445535152796997762L;

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

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
		name = "project_skill",
		joinColumns = @JoinColumn(name = "skill_id"),
		inverseJoinColumns = @JoinColumn(name = "project_id"))
	private List<Project> projects;

//	@ManyToMany(mappedBy = "skills", fetch = FetchType.EAGER)
//	private List<Project> projects;
}
