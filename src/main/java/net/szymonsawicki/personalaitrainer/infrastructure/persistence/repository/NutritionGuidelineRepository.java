package net.szymonsawicki.personalaitrainer.infrastructure.persistence.repository;

import net.szymonsawicki.personalaitrainer.domain.entity.NutritionGuideline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NutritionGuidelineRepository extends JpaRepository<NutritionGuideline, Long> {}
