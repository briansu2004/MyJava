package com.sutek.skill.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.time.LocalDate;
import org.junit.jupiter.api.Test;

class BasicBirthdayServiceTest {
	BasicBirthdayService birthdayService = new BasicBirthdayService();

	@Test
	void testGetBirthdayDOW() {
		String dow = birthdayService.getBirthDOW(LocalDate.of(1979, 7, 14));
		assertEquals("SATURDAY", dow);
		dow = birthdayService.getBirthDOW(LocalDate.of(2018, 1, 23));
		assertEquals("TUESDAY", dow);
		dow = birthdayService.getBirthDOW(LocalDate.of(1972, 3, 17));
		assertEquals("FRIDAY", dow);
		dow = birthdayService.getBirthDOW(LocalDate.of(1945, 12, 2));
		assertEquals("SUNDAY", dow);
		dow = birthdayService.getBirthDOW(LocalDate.of(2003, 8, 4));
		assertEquals("MONDAY", dow);
	}

	@Test
	void testGetBirthdayChineseSign() {
		String dow = birthdayService.getChineseZodiac(LocalDate.of(1979, 7, 14));
		assertEquals("Sheep", dow);
		dow = birthdayService.getChineseZodiac(LocalDate.of(2018, 1, 23));
		assertEquals("Dog", dow);
		dow = birthdayService.getChineseZodiac(LocalDate.of(1972, 3, 17));
		assertEquals("Rat", dow);
		dow = birthdayService.getChineseZodiac(LocalDate.of(1945, 12, 2));
		assertEquals("Rooster", dow);
		dow = birthdayService.getChineseZodiac(LocalDate.of(2003, 8, 4));
		assertEquals("Sheep", dow);
	}

	@Test
	void testGetBirthdayStarSign() {
		String dow = birthdayService.getStarSign(LocalDate.of(1979, 7, 14));
		assertEquals("Cancer", dow);
		dow = birthdayService.getStarSign(LocalDate.of(2018, 1, 23));
		assertEquals("Aquarius", dow);
		dow = birthdayService.getStarSign(LocalDate.of(1972, 3, 17));
		assertEquals("Pisces", dow);
		dow = birthdayService.getStarSign(LocalDate.of(1945, 12, 2));
		assertEquals("Sagittarius", dow);
		dow = birthdayService.getStarSign(LocalDate.of(2003, 8, 4));
		assertEquals("Leo", dow);
	}
}