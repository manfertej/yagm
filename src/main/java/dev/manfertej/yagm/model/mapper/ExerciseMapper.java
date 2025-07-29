package dev.manfertej.yagm.model.mapper;

import dev.manfertej.yagm.model.dto.ClientDTO;
import dev.manfertej.yagm.model.dto.ExerciseDTO;
import dev.manfertej.yagm.model.entity.Client;
import dev.manfertej.yagm.model.entity.Exercise;
import org.modelmapper.ModelMapper;

public class ExerciseMapper {

	public static ExerciseDTO toDTO(Exercise exercise) {

		return new ModelMapper().map(exercise, ExerciseDTO.class);
	}

	public static Exercise toEntity(ExerciseDTO exerciseDTO) {

		return new ModelMapper().map(exerciseDTO, Exercise.class);
	}


}
