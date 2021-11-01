#CREATE SCHEMA `skill_inventory` ;

use skill_inventory;

DROP TABLE IF EXISTS skill;

CREATE TABLE IF NOT EXISTS skillskillskill (
    skill_id INT AUTO_INCREMENT PRIMARY KEY,
    skill_name VARCHAR(255) NOT NULL,
    skill_name_long VARCHAR(1000),
    skill_description VARCHAR(2000),
    status TINYINT NOT NULL DEFAULT 0, # 0: Not yet / Learning; 1: Done;
    priority TINYINT NOT NULL DEFAULT 0, # 0: general; 1: #1 - most important; 2: #2 - less important than 1 ...
    created_dt TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

#ALTER TABLE `skill_inventory`.`skill` DROP COLUMN `dtype`;

select * from skill;
select * from skill where name like '%%';

#INSERT INTO SKILL (skill_name) VALUES ('AI');

SELECT s FROM skill s WHERE s.skill_name LIKE '%azure%';

SELECT * FROM skill WHERE skill_name LIKE '%azure%';

#Error Code: 1175. You are using safe update mode and you tried to update a table without a WHERE that uses a KEY column.  
#To disable safe mode, toggle the option in Preferences -> SQL Editor and reconnect.	0.000 sec
#update skill set priority = 1;
#update skill set priority = 1 where priority = 0;

