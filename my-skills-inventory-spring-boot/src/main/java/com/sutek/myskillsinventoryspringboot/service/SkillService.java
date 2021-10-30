package com.sutek.myskillsinventoryspringboot.service;

import com.sutek.myskillsinventoryspringboot.model.Skill;

import java.util.List;

public interface SkillService {
	Skill saveSkill(Skill skill);
	List<Skill> getAllSkills();
	Skill getSkillById(long skillId);
	Skill updateSkill(Skill skill, long skillId);
//	Skill patchSkill(Skill skill, long skillId);
	void deleteSkill(long skillId);
}
