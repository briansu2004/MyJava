package com.sutek.skill.api;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sutek.skill.api.request.SkillRequest;
import com.sutek.skill.entity.Skill;
import com.sutek.skill.service.SkillService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@AutoConfigureMockMvc
@ContextConfiguration(classes = {SkillController.class, SkillService.class, Skill.class, SkillRequest.class})
@WebMvcTest
class SkillControllerIT {
	private final static String postSkillURI = "/skills";

	@MockBean
	private Skill skill;

	@MockBean
	private SkillRequest skillRequest;

	@MockBean
	private SkillService skillService;

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private MockMvc mockMvc;

	@BeforeEach
	void setUp() {
	}

	@AfterEach
	void tearDown() {
	}

	@Test
	@DisplayName("Test POST skill")
	public void testSaveSkill(@Qualifier("skillRequest") SkillRequest newSkillRequest) throws Exception {
		SkillRequest skillRequest = new SkillRequest("Java");
		Skill skill = new Skill("id", "Java");

		Mockito.when(skillService.createSkill(any())).thenReturn(skill);

		MvcResult result = mockMvc.perform(MockMvcRequestBuilders
				.post(postSkillURI)
				//.accept(MediaType.APPLICATION_JSON)
				.contentType("application/json")
				//.param("sendWelcomeMail", "true")

				.content(objectMapper.writeValueAsString(skillRequest)))

				//.content(asJsonString(skillRequest)))

//				.andExpect(status().isCreated())
				.andReturn();

		// Skill resultSkill = (Skill) result.getResponse();
		assertNotNull(result.getResponse());
		// assertEquals(expectedSkill, resultSkill);
	}

	static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
//
//{
//	"skillId": "077b5c05-cf8f-48f8-8d48-ee321e2dabed",
//	"skillName": "GitLab"
//}

