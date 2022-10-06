package com.sutek.skill.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@JsonSerialize
@JsonDeserialize
public class Skill {
	@JsonProperty("skillId")
	private String skillId;
	@JsonProperty("skillName")
	private String skillName;
}
