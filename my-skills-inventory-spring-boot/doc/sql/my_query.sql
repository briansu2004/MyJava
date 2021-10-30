#CREATE SCHEMA `skill_inventory` ;

use skill_inventory;

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


select * from skill;

