package net.szymonsawicki.personalaitrainer.domain.entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "progression_strategies")
@Getter
@Setter
public class ProgressionStrategy {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "progression_timeframe_weeks")
  private Integer progressionTimeframeWeeks;

  @Column(name = "progression_method", length = 500)
  private String progressionMethod;

  @ElementCollection
  @CollectionTable(
      name = "progression_milestones",
      joinColumns = @JoinColumn(name = "progression_strategy_id"))
  @Column(name = "milestone", length = 500)
  private List<String> progressionMilestones = new ArrayList<>();

  @ElementCollection
  @CollectionTable(
      name = "adjustment_guidelines",
      joinColumns = @JoinColumn(name = "progression_strategy_id"))
  @Column(name = "guideline", length = 500)
  private List<String> adjustmentGuidelines = new ArrayList<>();
}
