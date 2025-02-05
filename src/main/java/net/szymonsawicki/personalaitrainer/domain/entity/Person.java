package net.szymonsawicki.personalaitrainer.domain.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import net.szymonsawicki.personalaitrainer.domain.type.Gender;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "persons")
@Getter
@Setter
public class Person {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "first_name", nullable = false)
  private String firstName;

  @Column(name = "last_name", nullable = false)
  private String lastName;

  @Column(name = "mail_address", unique = true, nullable = false)
  private String mailAddress;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private Gender gender;

  @Column(nullable = false)
  private Integer height;

  @Column(name = "starting_weight", nullable = false)
  private Integer startingWeight;

  @Column(name = "experience_years", nullable = false)
  private Integer experienceYears;

  @Column(name = "birth_date", nullable = false)
  private LocalDate birthDate;

  @Column(name = "chronic_illnesses")
  private String chronicIllnesses;

  @Column(name = "injuries")
  private String injuries;

  @CreationTimestamp
  @Column(name = "created_at", nullable = false, updatable = false)
  private LocalDateTime createdAt;

  @UpdateTimestamp
  @Column(name = "modified_at")
  private LocalDateTime modifiedAt;

  @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<TrainingPlan> trainingPlans = new ArrayList<>();

  @OneToOne(mappedBy = "person", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private TrainingPreference trainingPreference;
}
