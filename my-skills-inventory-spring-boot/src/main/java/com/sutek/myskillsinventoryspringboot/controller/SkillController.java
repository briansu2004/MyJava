package com.sutek.myskillsinventoryspringboot.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.sutek.myskillsinventoryspringboot.exception.ResourceNotFoundException;
import com.sutek.myskillsinventoryspringboot.exception.ValidationException;
import com.sutek.myskillsinventoryspringboot.helper.ApiConstants;
import com.sutek.myskillsinventoryspringboot.model.FieldFilterSkill;
import com.sutek.myskillsinventoryspringboot.model.Skill;
import com.sutek.myskillsinventoryspringboot.service.SkillService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/skill-inventory")
public class SkillController {
	private final SkillService skillService;

	public SkillController(SkillService skillService) {
		super();
		this.skillService = skillService;
	}

	// Get all skills
	// GET
	// http://localhost:8080/api/v1/skill-inventory/skills
	@GetMapping(value = "skills")
	public ResponseEntity<List<Skill>> getAllSkills() {
		return new ResponseEntity<List<Skill>>(skillService.getAllSkills(), HttpStatus.OK);
	}
//	public List<Skill> getAllSkills() {
//		return skillService.getAllSkills();
//	}
//

	// Get one skill by Id
	// GET
	// http://localhost:8080/api/v1/skill-inventory/skills/1
	//
	// Use Java 8 Stream API?
	@GetMapping(value = "skills/{id}")
	public ResponseEntity<Skill> getSkillById(@PathVariable("id") long skillId) {
		return new ResponseEntity<Skill>(skillService.getSkillById(skillId), HttpStatus.OK);
	}
//	public Skill getSkillById(@PathVariable("id") long skillId) {
//		return skillService.getSkillById(skillId);
//	}

	// Filtering/searching skills by keyword
	// GET
	// http://localhost:8080/api/v1/skill-inventory/skillsSearch?keyword=$keyword
	@GetMapping(value = "skillsSearch")
	public ResponseEntity<List<Skill>> searchSkillByKeyword(@RequestParam(required = true) String keyword) {
		return new ResponseEntity<List<Skill>>(skillService.getAllSkills().stream()
			.filter(s -> s.getSkillName().trim().toLowerCase().contains(keyword.trim().toLowerCase()))
			.collect(Collectors.toList()), HttpStatus.OK);
	}
	//
	// This is implemented with @Query
//	@GetMapping(value = "skillsSearch")
//	public ResponseEntity<List<Skill>> searchSkillByKeywordWithQuery(@RequestParam(required = true) String keyword) {
//		return new ResponseEntity<List<Skill>>(skillService.findBySkillNameKeyword(keyword), HttpStatus.OK);
//	}

	// Get all skills with sorting
	// GET
	// http://localhost:8080/api/v1/skill-inventory/skillsSorting?sort=skillName
	// http://localhost:8080/api/v1/skill-inventory/skillsSorting?sort=skillName&order=desc
	@GetMapping(value = "skillsSorting")
	public ResponseEntity<List<Skill>> getAllSkillsWithSorting(@RequestParam(name = "sort", required = true) String sort, @RequestParam(name = "order", required = false) String order) {
		Comparator<Skill> comparator;
		String sortField = StringUtils.trim(sort).toLowerCase();
		switch (sortField) {
			case "name":
			case "skillname":
				comparator = Comparator.comparing(Skill::getSkillName);
				break;
			case "namelong":
			case "skillnamelong":
				comparator = Comparator.comparing(Skill::getSkillNameLong);
				break;
			case "description":
			case "skilldescription":
				comparator = Comparator.comparing(Skill::getSkillDescription);
				break;
			case "status":
			case "skillstatus":
				comparator = Comparator.comparing(Skill::getSkillStatus);
				break;
			case "priority":
			case "skillpriority":
				comparator = Comparator.comparing(Skill::getSkillPriority);
				break;
			case "id":
			case "skillid":
			default:
				comparator = Comparator.comparing(Skill::getSkillId);
		}

		List<Skill> allSkills = skillService.getAllSkills();

		if (comparator != null) {
			boolean orderAsc = StringUtils.isEmpty(order) || !order.trim().equalsIgnoreCase(ApiConstants.DESC);

			if (orderAsc) {
				allSkills.sort(comparator);
			} else {
				allSkills.sort(comparator.reversed());
			}
		}

		return new ResponseEntity<List<Skill>>(allSkills, HttpStatus.OK);
	}

//	public ResponseEntity<List<Skill>> getAllSkillsWithSorting(@RequestParam(name = "sort", required = true) String sort, @RequestParam(name = "order", required = false) String order) {
//		boolean orderAsc = true;
//
//		if (StringUtils.isNotEmpty(order) && order.trim().equalsIgnoreCase("desc")) {
//			orderAsc = false;
//		}
//
//		List<Skill> allSkills = skillService.getAllSkills();
//
//		//Comparator comparator;
//		String sortField = StringUtils.trim(sort).toLowerCase();
//		switch(sortField) {
//			case "name":
//			case "skillname":
//				allSkills.sort((s1, s2) -> s1.getSkillName().compareTo(s2.getSkillName()));
//				break;
//			case "namelong":
//			case "skillnamelong":
//				allSkills.sort((s1, s2) -> s1.getSkillNameLong().compareTo(s2.getSkillNameLong()));
//				break;
//			case "description":
//			case "skilldescription":
//				allSkills.sort((s1, s2) -> s1.getSkillDescription().compareTo(s2.getSkillDescription()));
//				break;
//			case "status":
//			case "skillstatus":
//				allSkills.sort((s1, s2) -> Integer.compare(s1.getSkillStatus(), s2.getSkillStatus()));
//				break;
//			case "priority":
//			case "skillpriority":
//				allSkills.sort((s1, s2) -> Integer.compare(s1.getSkillPriority(), s2.getSkillPriority()));
//				break;
//			case "id":
//			case "skillid":
//				allSkills.sort((s1, s2) -> Long.compare(s1.getSkillId(), s2.getSkillId()));
//				break;
//			default:
//				allSkills.sort((s1, s2) -> Long.compare(s1.getSkillId(), s2.getSkillId()));
//		}
//
//		if (!orderAsc) {
//			allSkills.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList());
//		}
//
//		return new ResponseEntity<List<Skill>>(allSkills, HttpStatus.OK);
//	}

	// Get all skills with pagination and offset
	// GET
	// http://localhost:8080/api/v1/skill-inventory/skillsPaging
	// http://localhost:8080/api/v1/skill-inventory/skillsPaging?offset=20
	// http://localhost:8080/api/v1/skill-inventory/skillsPaging?limit=3
	// http://localhost:8080/api/v1/skill-inventory/skillsPaging?offset=10&limit=5
	//
	// The default values are limit=20 and offset=0.
	@GetMapping(value = "skillsPaging")
	public ResponseEntity<List<Skill>> skillPaging(@RequestParam(name="offset", required = false) String offset,
	                                               @RequestParam(name="limit", required = false) String limit) {

		long pageOffset, pageLimit;

		if (StringUtils.isEmpty(offset)) {
			pageOffset = ApiConstants.DEFAULT_OFFSET;
		} else {
			pageOffset = Long.parseLong(offset.trim());
		}

		if (StringUtils.isEmpty(limit)) {
			pageLimit = ApiConstants.DEFAULT_LIMIT;
		} else {
			pageLimit = Long.parseLong(limit.trim());
		}

		return new ResponseEntity<List<Skill>>(skillService.getAllSkills().stream()
			.skip(pageOffset)
			.limit(pageLimit)
			.collect(Collectors.toList()), HttpStatus.OK);
	}
	//
	// This is implemented with @Query
//	@GetMapping(value = "skillsSearch")
//	public ResponseEntity<List<Skill>> searchSkillByKeywordWithQuery(@RequestParam(required = true) String keyword) {
//		return new ResponseEntity<List<Skill>>(skillService.findBySkillNameKeyword(keyword), HttpStatus.OK);
//	}


	// Get all skills with field selection
	// GET
	// http://localhost:8080/api/v1/skill-inventory/skills?fields=name,priority
	// GET
	// http://localhost:8080/api/v1/skill-inventory/skills?fields=skillName,skillName
	@GetMapping(value = "skillsFields")
	public ResponseEntity<?> getAllSkillsWithFieldsList(@RequestParam(name = "fieldList", required = true) String fieldList) throws ValidationException, JsonProcessingException {
		if (ObjectUtils.isEmpty(fieldList)) {
			throw new ValidationException("Search_Skills_with_Field_List", "fieldList", fieldList);
		}

		List<FieldFilterSkill> allSkills = skillService.getAllFieldFilterSkills();

		SimpleFilterProvider filterProvider = new SimpleFilterProvider().addFilter("fieldFilter",
			SimpleBeanPropertyFilter.filterOutAllExcept(fieldList.split(",")));
		ObjectMapper mapper = new ObjectMapper().setFilterProvider(filterProvider);
		return new ResponseEntity<>(mapper.readValue(mapper.writeValueAsString(allSkills), Object.class),
			HttpStatus.OK);
	}

	// Add a new skill
	// POST
	// http://localhost:8080/api/v1/skill-inventory/skills
	@PostMapping(value = "skills")
	public ResponseEntity<Skill> saveSkill(@RequestBody Skill skill) {
		return new ResponseEntity<Skill>(skillService.saveSkill(skill), HttpStatus.CREATED);
	}

	// Update one skill by Id (completely)
	// PUT
	// http://localhost:8080/api/v1/skill-inventory/skills/2
	//@CrossOrigin(origins = "http://localhost:8089")
	@PutMapping(value = "skills/{id}")
	public ResponseEntity<Skill> updateSkill(@RequestBody Skill skill, @PathVariable("id") long skillId) {
		return new ResponseEntity<Skill>(skillService.updateSkill(skill, skillId), HttpStatus.OK);
	}

	// Update one skill by Id (partially)
	// PATCH
	// http://localhost:8080/api/v1/skill-inventory/skills/3
	@PatchMapping(value = "skills/{id}")
	public ResponseEntity<Skill> patchSkill(@RequestBody Skill skill, @PathVariable("id") long skillId) {
		return new ResponseEntity<Skill>(skillService.patchSkill(skill, skillId), HttpStatus.OK);
	}

//	// PATCH
//	// http://localhost:8080/api/v1/skill-inventory/skills/3
//	@PatchMapping(path = "skills/patch/{id}", consumes = "application/json-patch+json")
//	public ResponseEntity<Skill> patchSkillWithJsonPatch(@RequestBody JsonPatch skillPatch,
//	                                               @PathVariable("id") long skillId) {
//		try {
//			Skill skill = skillService.getSkillById(skillId);
//			Skill skillPatched = applyPatchToSkill(skillPatch, skill);
//			skillService.saveSkill(skillPatched);
//			return ResponseEntity.ok(skillPatched);
//		} catch (JsonPatchException | JsonProcessingException e) {
//			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//		} catch (ResourceNotFoundException e) {
//			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//		}
//	}
//
//	private Skill applyPatchToSkill(JsonPatch skillPatch, Skill targetSkill) throws JsonPatchException, JsonProcessingException {
//		ObjectMapper objectMapper = new ObjectMapper();
//		objectMapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
//		JsonNode patched = skillPatch.apply(objectMapper.convertValue(targetSkill, JsonNode.class));
//		return objectMapper.treeToValue(patched, Skill.class);
//	}

	// Delete a skill by Id
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
