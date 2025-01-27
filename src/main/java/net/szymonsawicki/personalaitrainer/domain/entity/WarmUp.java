package net.szymonsawicki.personalaitrainer.domain.entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "warm_ups")
@Getter
@Setter
public class WarmUp {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @OneToMany(mappedBy = "warmUp", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Exercise> exercises = new ArrayList<>();

  @Column(name = "duration")
  private Integer duration;
}
