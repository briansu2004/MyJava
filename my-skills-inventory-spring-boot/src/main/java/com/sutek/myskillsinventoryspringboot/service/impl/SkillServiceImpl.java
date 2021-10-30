package com.sutek.myskillsinventoryspringboot.service.impl;

import com.sutek.myskillsinventoryspringboot.exception.ResourceNotFoundException;
import com.sutek.myskillsinventoryspringboot.model.Skill;
import com.sutek.myskillsinventoryspringboot.repository.SkillRepository;
import com.sutek.myskillsinventoryspringboot.service.SkillService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillServiceImpl implements SkillService {

	private final SkillRepository skillRepository;

	public SkillServiceImpl(SkillRepository skillRepository) {
		super();
		this.skillRepository = skillRepository;
	}

	// GET
	// http://localhost:8080/api/v1/skill-inventory/skills
	@Override
	public List<Skill> getAllSkills() {
		return skillRepository.findAll();
	}

	// GET
	// http://localhost:8080/api/v1/skill-inventory/skills/1
	@Override
	public Skill getSkillById(long skillId) {
		return skillRepository.findById(skillId).orElseThrow(() -> new ResourceNotFoundException("Skill", "skillId", skillId));
	}

	// POST
	// http://localhost:8080/api/v1/skill-inventory/skills
	@Override
	public Skill saveSkill(Skill skill) {
		return skillRepository.save(skill);
	}

	// PUT
	// http://localhost:8080/api/v1/skill-inventory/skills/2
	@Override
	public Skill updateSkill(Skill skill, long skillId) {
		// Fetch the skill to be updated
		Skill existingSkill = skillRepository.findById(skillId).orElseThrow(() -> new ResourceNotFoundException("Skill", "Id", skillId));

		// Update this skill
		existingSkill.setSkillName(skill.getSkillName());
		existingSkill.setSkillNameLong(skill.getSkillNameLong());
		existingSkill.setSkillDescription(skill.getSkillDescription());
		existingSkill.setSkillStatus(skill.getSkillStatus());
		existingSkill.setSkillPriority(skill.getSkillPriority());

		// Save updated skill to DB
		skillRepository.save(existingSkill);

		return existingSkill;
	}

//	// PATCH
//	// http://localhost:8080/api/v1/skill-inventory/skills/3
//	@Override
//	public Skill patchSkill(Skill skill, long skillId) {
//		// Fetch the skill to be updated
//		Skill existingSkill = skillRepository.findById(skillId).orElseThrow(() -> new ResourceNotFoundException("Skill", "Id", skillId));
//
//		// Update this skill
//		if (skill.getSkillName() != null) {
//			existingSkill.setSkillName(skill.getSkillName());
//		}
//
//		if (skill.getSkillName() != null) {
//			existingSkill.setSkillNameLong(skill.getSkillNameLong());
//		}
//
//		if (skill.getSkillDescription() != null) {
//			existingSkill.setSkillDescription(skill.getSkillDescription());
//		}
//
//		if (skill.getSkillStatus() != 0) {
//			existingSkill.setSkillStatus(skill.getSkillStatus());
//		}
//
//		if (skill.getSkillPriority() != 0) {
//			existingSkill.setSkillPriority(skill.getSkillPriority());
//		}
//
//		// Save updated skill to DB
//		skillRepository.save(existingSkill);
//
//		return existingSkill;
//	}

	// DELETE
	// http://localhost:8080/api/v1/skill-inventory/skills/4
	@Override
	public void deleteSkill(long skillId) {
		// Check the skill to be deleted
		skillRepository.findById(skillId).orElseThrow(() -> new ResourceNotFoundException("Skill", "Id", skillId));

		// Delete this skill from DB
		skillRepository.deleteById(skillId);
	}
}
