package com.sutek.myskillsinventoryspringboot.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import com.sutek.myskillsinventoryspringboot.exception.ResourceNotFoundException;
import com.sutek.myskillsinventoryspringboot.helper.ApiConstants;
import com.sutek.myskillsinventoryspringboot.model.Skill;
import com.sutek.myskillsinventoryspringboot.service.SkillService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/skill-inventory")
public class SkillController {
	private final SkillService skillService;

	public SkillController(SkillService skillService) {
		super();
		this.skillService = skillService;
	}

	// GET
	// http://localhost:8080/api/v1/skill-inventory/skills
	@GetMapping(value = "skills")
	public List<Skill> getAllSkills() {
		return skillService.getAllSkills();
	}

	// GET
	// http://localhost:8080/api/v1/skill-inventory/skills/1
	@GetMapping(value = "skills/{id}")
	public Skill getSkillById(@PathVariable("id") long skillId) {
		return skillService.getSkillById(skillId);
	}

	// POST
	// http://localhost:8080/api/v1/skill-inventory/skills
	@PostMapping(value = "skills")
	public ResponseEntity<Skill> saveSkill(@RequestBody Skill skill) {
		return new ResponseEntity<Skill>(skillService.saveSkill(skill), HttpStatus.CREATED);
	}

	// PUT
	// http://localhost:8080/api/v1/skill-inventory/skills/2
	@PutMapping(value = "skills/{id}")
	public ResponseEntity<Skill> updateSkill(@RequestBody Skill skill, @PathVariable("id") long skillId) {
		return new ResponseEntity<Skill>(skillService.updateSkill(skill, skillId), HttpStatus.OK);
	}

	// PATCH
	// http://localhost:8080/api/v1/skill-inventory/skills/3
	@PatchMapping(path = "skills/{id}", consumes = "application/json-patch+json")
	public ResponseEntity<Skill> patchSkill(@RequestBody JsonPatch skillPatch, @PathVariable("id") long skillId) {
		//return new ResponseEntity<Skill>(skillService.updateSkill(skill, skillId), HttpStatus.OK);

		try {
			Skill skill = skillService.getSkillById(skillId);
			Skill skillPatched = applyPatchToSkill(skillPatch, skill);
			skillService.saveSkill(skillPatched);
			return ResponseEntity.ok(skillPatched);
		} catch (JsonPatchException | JsonProcessingException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		} catch (ResourceNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	private Skill applyPatchToSkill(JsonPatch skillPatch, Skill targetSkill) throws JsonPatchException, JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
		JsonNode patched = skillPatch.apply(objectMapper.convertValue(targetSkill, JsonNode.class));
		return objectMapper.treeToValue(patched, Skill.class);
	}

	// DELETE
	// http://localhost:8080/api/v1/skill-inventory/skills/4
	@DeleteMapping(value = "skills/{id}")
	public ResponseEntity<String> deleteSkill(@PathVariable("id") long skillId) {
		try {
			Skill skill = skillService.getSkillById(skillId);
		} catch (ResourceNotFoundException e) {
			return new ResponseEntity<String>(String.format(ApiConstants.THE_SKILL_IS_NOT_FOUND, skillId), HttpStatus.NOT_FOUND);
		}

		skillService.deleteSkill(skillId);

		return new ResponseEntity<String>(String.format(ApiConstants.THE_SKILL_HAS_BEEN_DELETED_SUCCESSFULLY,
			skillId), HttpStatus.OK);
	}
}
