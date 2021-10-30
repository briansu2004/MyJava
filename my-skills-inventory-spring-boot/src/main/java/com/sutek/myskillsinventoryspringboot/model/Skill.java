package com.sutek.myskillsinventoryspringboot.model;


import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
@Entity
@Table(name="skill")
public class Skill {
	@Id
	@Column(name="skill_id")
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long skillId;

	@Column(name="skill_name", nullable = false)
	private String skillName;

	@Column(name="skill_name_long")
	private String skillNameLong;

	@Column(name="skill_description")
	private String skillDescription;

	@Column(name="status")
	private int skillStatus;

	@Column(name="priority")
	private int skillPriority;

	@Override
	public String toString() {
		return "Skill{" +
			"skillId=" + skillId +
			", skillName='" + skillName + '\'' +
			", skillNameLong='" + skillNameLong + '\'' +
			", skillDescription='" + skillDescription + '\'' +
			", skillStatus=" + skillStatus +
			", skillPriority=" + skillPriority +
			'}';
	}
}
