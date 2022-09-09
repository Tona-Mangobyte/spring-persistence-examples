package com.mb.persistence.repositories;

import com.mb.persistence.models.SkillDescription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillDescriptionRepository extends JpaRepository<SkillDescription, Long> {
}
