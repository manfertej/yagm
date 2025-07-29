package dev.manfertej.yagm.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(
	name = "\"EXERCISES\"",
	// Pair (name, tool) should be unique
	uniqueConstraints =
		{@UniqueConstraint(columnNames = {"Name", "Equipment"})}
)
public class Exercise {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id", unique = true, nullable = false)
	private Long ID;

	@Column(name = "Name", nullable = false)
	private String name;
	@Column(name = "Recommended_Sets", nullable = false)
	private int recommendedSets;
	@Column(name = "Recommended_Min_Reps", nullable = false)
	private int recommendedMinReps;
	@Column(name = "Recommended_Max_Reps", nullable = false)
	private int recommendedMaxReps;

	@Column(name = "Equipment", nullable = false)
	private String equipment;

	@Enumerated(EnumType.STRING)
	@Column(name = "Muscle", nullable = false)
	private Muscle muscle;

	private String url;

	private String instructions;
}
