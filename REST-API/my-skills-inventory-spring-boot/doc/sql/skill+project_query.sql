#CREATE SCHEMA `skill_inventory` ;

use skill_inventory;

DROP TABLE IF EXISTS project_skill;

CREATE TABLE IF NOT EXISTS project_skill (
    project_skill_id INT AUTO_INCREMENT PRIMARY KEY,
    project_id INT NOT NULL DEFAULT 0,
    skill_id INT NOT NULL DEFAULT 0,
    status TINYINT NOT NULL DEFAULT 1, # 0: invalid; 1: valid
    created_dt TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);


select * from project;
# project_id, client_id, project_name, project_description, status, created_dt
#'1', '1', 'Seashell Phase 2', 'Extend Warranty Sales Management API REST', '0', '2021-11-01 01:44:11'

select * from skill where skill_name in ('Java', 'API', 'Spring Boot', 'Openshift', 'REST', 'GCP', 'DevOps', 'Pipeline');

-- TRUNCATE TABLE project_skill;

-- INSERT INTO project_skill (project_id, skill_id) 
-- select 1, skill_id from skill where skill_name in ('Java', 'API', 'Spring Boot', 'Openshift', 'REST', 'GCP', 'DevOps', 'Pipeline');

-- INSERT INTO project_skill (project_id, skill_id) 
-- select 2, skill_id from skill where skill_name in ('Java', 'API', 'Spring Boot', 'Angular', 'REST', 'Full Stack', 'JavaScript', 'DevOps', 'GitLabs', 'Microservices', 'JSON', 'XML');

select * from project_skill;