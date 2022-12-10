#CREATE SCHEMA `skill_inventory` ;

use skill_inventory;

DROP TABLE IF EXISTS client;

# MySQL int Maximum Value Signed: 2147483647
CREATE TABLE IF NOT EXISTS client (
    client_id INT AUTO_INCREMENT PRIMARY KEY,
    agent_id INT NOT NULL DEFAULT 0, # 0: no agent
    client_name VARCHAR(255) NOT NULL,
    client_description VARCHAR(2000),
    status TINYINT NOT NULL DEFAULT 1, # 1: valid
    created_dt TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- INSERT INTO client (client_name, agent_id, client_description) VALUES ('Telus', 1, 'Extend Warranty Sales Management API REST');
-- INSERT INTO client (client_name, agent_id, client_description) VALUES ('MCS', 2, 'CPIN');

select * from client;
# client_id, agent_id, client_name, client_description, status, created_dt
#'1', '1', 'Telus', 'Extend Warranty Sales Management API REST', '1', '2021-11-01 01:36:04'
# '2', '2', 'MCS', 'CPIN', '1', '2021-11-01 01:51:01'


