package com.sutek.skill.api;

import com.sutek.skill.api.request.SkillRequest;
import com.sutek.skill.api.response.SkillResponse;
import com.sutek.skill.entity.Skill;
import com.sutek.skill.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.rmi.ServerException;
import java.time.LocalDate;

@RestController
public class SkillController {
	@Autowired
	SkillService skillService;

	@PostMapping("/skills")
	public ResponseEntity<Skill> saveSkill(@RequestBody SkillRequest skillRequest) {
		return new ResponseEntity<Skill>(skillService.createSkill(skillRequest), HttpStatus.CREATED);
	}
}
