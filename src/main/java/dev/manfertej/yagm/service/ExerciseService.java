package dev.manfertej.yagm.service;

import dev.manfertej.yagm.model.entity.Exercise;
import dev.manfertej.yagm.model.entity.Muscle;
import dev.manfertej.yagm.repository.ExerciseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExerciseService {

	private final ExerciseRepository exerciseRepository;


	public List<Exercise> getByMuscles(List<Muscle> muscle) {

		return this.exerciseRepository.findByMuscleIn(muscle);
	}

}
