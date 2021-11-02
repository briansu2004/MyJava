package com.sutek.myskillsinventoryspringboot.service;

import com.sutek.myskillsinventoryspringboot.model.FieldFilterSkill;
import com.sutek.myskillsinventoryspringboot.model.Skill;

import java.util.List;

public interface SkillService {
	List<Skill> getAllSkills();
	List<FieldFilterSkill> getAllFieldFilterSkills();
	Skill getSkillById(long skillId);
	Skill saveSkill(Skill skill);
	Skill updateSkill(Skill skill, long skillId);
	Skill patchSkill(Skill skill, long skillId);
	void deleteSkill(long skillId);

//	List<Skill> findBySkillNameKeyword(String keyword);
}
