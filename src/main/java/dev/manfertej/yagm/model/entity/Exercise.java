package dev.manfertej.yagm.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Exercises")
public class Exercise {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id", unique = true, nullable = false)
	private Long ID;

	@Column(name = "name", nullable = false)
	private String name;
	@Column(name = "Recommended_Sets", nullable = false)
	private int recommendedSets;
	@Column(name = "Recommended_Min_Reps", nullable = false)
	private int recommendedMinReps;
	@Column(name = "Recommended_Max_Reps", nullable = false)
	private int recommendedMaxReps;

	@Column(name = "Tool", nullable = false)
	private String tool;

	@Enumerated(EnumType.STRING)
	@Column(name = "Muscle", nullable = false)
	private Muscle muscle;

	private String url;

	private String instructions;
}
