package com.sutek.myskillsinventoryspringboot.repository;

import com.sutek.myskillsinventoryspringboot.model.FieldFilterSkill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FieldFilterSkillRepository extends JpaRepository<FieldFilterSkill, Long> {
}
