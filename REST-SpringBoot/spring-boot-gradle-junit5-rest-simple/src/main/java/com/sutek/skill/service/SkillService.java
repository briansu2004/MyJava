package com.sutek.skill.service;

import com.sutek.skill.api.request.SkillRequest;
import com.sutek.skill.api.response.SkillResponse;
import com.sutek.skill.entity.Skill;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class SkillService {
	public Skill createSkill(SkillRequest skillRequest) {
		UUID uuid = UUID.randomUUID();
		return new Skill(uuid.toString(), skillRequest.getSkillName());
	}
}
