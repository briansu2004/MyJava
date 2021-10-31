package com.sutek.myskillsinventoryspringboot.service;

import com.sutek.myskillsinventoryspringboot.model.FieldFilterSkill;
import com.sutek.myskillsinventoryspringboot.model.Skill;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SkillService {
	Skill saveSkill(Skill skill);
	List<Skill> getAllSkills();
	List<FieldFilterSkill> getAllFieldFilterSkills();
	Skill getSkillById(long skillId);
	Skill updateSkill(Skill skill, long skillId);
	Skill patchSkill(Skill skill, long skillId);
	void deleteSkill(long skillId);

//	List<Skill> findBySkillNameKeyword(String keyword);
}
