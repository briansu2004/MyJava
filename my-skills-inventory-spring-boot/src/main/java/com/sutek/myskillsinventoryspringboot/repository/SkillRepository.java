package com.sutek.myskillsinventoryspringboot.repository;

import com.sutek.myskillsinventoryspringboot.model.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Long> {
	// works
	// but switching to Java 8 Steam API
//	@Query("SELECT s FROM Skill s WHERE s.skillName LIKE %?1%")
//	List<Skill> findBySkillNameLike(String keyword);

	// Using @Query
	// Attention: it has to be Skill, not skill (need to match model/entity class name)
	//
	// This one performs exact match
	//@Query("SELECT s FROM Skill s WHERE s.skillName = ?1")
	// works
	//
	// Using @Query with Advanced LIKE Expressions
	// works
	//@Query("SELECT s FROM Skill s WHERE s.skillName LIKE %?1%")
	//
	//
	// Using @Query with Native Queries
	// works
	//@Query(value = "SELECT * FROM skill WHERE skill_name LIKE %?1%", nativeQuery = true)
	//
	// This is a bad grammar - not works
	//@Query(value = "SELECT * FROM skill WHERE skill_name LIKE '%?1%'", nativeQuery = true)
	//
	// This one performs exact match
	//@Query(value = "SELECT * FROM skill WHERE skill_name = ?1", nativeQuery = true)

//	List<Skill> findByNameNotLike(String name);
//
//	List<Skill> findByNameStartingWith(String startingWith);
//
//	List<Skill> findByNameEndingWith(String endingWith);
//
//	List<Skill> findByCategoryContaining(String category);
}
