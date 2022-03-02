#CREATE SCHEMA `skill_inventory` ;

use skill_inventory;

DROP TABLE IF EXISTS agent;

CREATE TABLE IF NOT EXISTS agent (
    agent_id INT AUTO_INCREMENT PRIMARY KEY,
    agent_name VARCHAR(255) NOT NULL,
    agent_description VARCHAR(2000),
    status TINYINT NOT NULL DEFAULT 1, # 1: valid
    created_dt TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- INSERT INTO agent (agent_name) VALUES ('York Digital');
-- INSERT INTO agent (agent_name) VALUES ('Igor');

select * from agent;
# agent_id, agent_name, agent_description, status, created_dt
#'1', 'York Digital', NULL, '1', '2021-11-01 01:35:35'
#'2', 'Igor', NULL, '1', '2021-11-01 01:49:47'


