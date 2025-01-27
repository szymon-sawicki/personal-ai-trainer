package net.szymonsawicki.personalaitrainer.domain.dto;

import java.util.List;

public record NutritionGuidelineDto(
    Long id,
    Integer dailyCalories,
    Integer proteinGrams,
    Integer carbsGrams,
    Integer fatsGrams,
    List<String> mealRecommendations,
    List<String> supplementRecommendations) {}
