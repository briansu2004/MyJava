package com.sutek.skill.service;

import com.sutek.skill.api.request.SkillRequest;
import com.sutek.skill.entity.Skill;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.time.LocalDate;
import org.junit.jupiter.api.Test;

class SkillServiceTest {
	SkillService skillService = new SkillService();

	@Test
	void testCreateSkill() {
		SkillRequest skillRequest = new SkillRequest("Java");
		Skill newSkill = skillService.createSkill(skillRequest);
		assertNotNull(newSkill);
		assertEquals("Java", newSkill.getSkillName());
	}

}