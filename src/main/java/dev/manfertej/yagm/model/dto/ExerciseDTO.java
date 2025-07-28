package dev.manfertej.yagm.model.dto;

import dev.manfertej.yagm.model.entity.Muscle;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExerciseDTO {

	@NotBlank
	private String name;
	@NotNull
	@Range(min = 1, max = 6)
	private int recommendedSets;
	@Range(min = 1, max = 12)
	private int recommendedMinReps;
	@Range(min = 1, max = 12)
	private int recommendedMaxReps;
	@NotBlank
	private String tool;
	@NotBlank
	private Muscle muscle;

	private String url;

	private String instructions;

}
