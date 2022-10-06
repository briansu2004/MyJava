package com.sutek.skill.api;

import java.time.LocalDate;

import com.sutek.skill.service.BirthdayService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/birthday")
public class BirthdayInfoController {
	private final BirthdayService birthdayService;

	public BirthdayInfoController(BirthdayService birthdayService) {
		this.birthdayService = birthdayService;
	}

	@PostMapping("/dayOfWeek")
	public String getDayOfWeek(@RequestBody String birthdayString) {
		LocalDate birthday = birthdayService.getValidBirthday(birthdayString);
		String dow = birthdayService.getBirthDOW(birthday);
		return dow;
	}

	@PostMapping("/chineseZodiac")
	public String getChineseZodiac(@RequestBody String birthdayString) {
		LocalDate birthday = birthdayService.getValidBirthday(birthdayString);
		String sign = birthdayService.getChineseZodiac(birthday);
		return sign;
	}

	@PostMapping("/starSign")
	public String getStarSign(@RequestBody String birthdayString) {
		LocalDate birthday = birthdayService.getValidBirthday(birthdayString);
		String sign = birthdayService.getStarSign(birthday);
		return sign;
	}

	@ExceptionHandler(RuntimeException.class)
	public final ResponseEntity<Exception> handleAllExceptions(RuntimeException ex) {
		return new ResponseEntity<Exception>(ex, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
