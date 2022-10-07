package com.sutek.skill.api.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Qualifier;

@Data
@AllArgsConstructor
//@Qualifier("skillRequest")
//@JsonSerialize
//@JsonDeserialize
public class SkillRequest {
	@JsonProperty("skillName")
	private String skillName;
}
