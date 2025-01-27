package net.szymonsawicki.personalaitrainer.domain.entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "nutrition_guidelines")
@Getter
@Setter
public class NutritionGuideline {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "daily_calories")
  private Integer dailyCalories;

  @Column(name = "protein_grams")
  private Integer proteinGrams;

  @Column(name = "carbs_grams")
  private Integer carbsGrams;

  @Column(name = "fats_grams")
  private Integer fatsGrams;

  @ElementCollection
  @CollectionTable(
      name = "meal_recommendations",
      joinColumns = @JoinColumn(name = "nutrition_guideline_id"))
  @Column(name = "recommendation", length = 500)
  private List<String> mealRecommendations = new ArrayList<>();

  @ElementCollection
  @CollectionTable(
      name = "supplement_recommendations",
      joinColumns = @JoinColumn(name = "nutrition_guideline_id"))
  @Column(name = "recommendation", length = 500)
  private List<String> supplementRecommendations = new ArrayList<>();
}
