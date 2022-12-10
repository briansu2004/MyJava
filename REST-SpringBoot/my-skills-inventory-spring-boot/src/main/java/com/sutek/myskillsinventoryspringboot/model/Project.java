package com.sutek.myskillsinventoryspringboot.model;

/*
CREATE TABLE IF NOT EXISTS project (
    project_id INT AUTO_INCREMENT PRIMARY KEY,
    client_id INT NOT NULL,
    project_name VARCHAR(255) NOT NULL,
    project_description VARCHAR(2000),
    status TINYINT NOT NULL DEFAULT 0, # 0: done; 1: WIP;
    created_dt TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
 */

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.io.Serial;
import java.util.List;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "skills")
@Table(name = "project")
public class Project {
	@Serial
	private static final long serialVersionUID = -5074721764083619562L;

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

	@ManyToMany(mappedBy = "projects",fetch = FetchType.EAGER)
	private List<Skill> skills;
}
