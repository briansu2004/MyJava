#CREATE SCHEMA `skill_inventory` ;

use skill_inventory;

DROP TABLE IF EXISTS project;

# MySQL int Maximum Value Signed: 2147483647
CREATE TABLE IF NOT EXISTS project (
    project_id INT AUTO_INCREMENT PRIMARY KEY,
    client_id INT NOT NULL,
    project_name VARCHAR(255) NOT NULL,
    project_description VARCHAR(2000),
    status TINYINT NOT NULL DEFAULT 0, # 0: done; 1: WIP;
    created_dt TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);


-- INSERT INTO project (client_id, project_name, project_description) VALUES (1, 'Seashell Phase 2', 'Extend Warranty Sales Management API REST');
-- INSERT INTO project (client_id, project_name, project_description) VALUES (2, 'CPIN', '');

select * from project;
# project_id, client_id, project_name, project_description, status, created_dt
#'1', '1', 'Seashell Phase 2', 'Extend Warranty Sales Management API REST', '0', '2021-11-01 01:44:11'

commit;


