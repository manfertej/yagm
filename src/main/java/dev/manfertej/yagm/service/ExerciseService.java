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


	public List<Exercise> getByMuscle(Muscle muscle) {
		var list = this.exerciseRepository.findByMuscle(muscle);

		return list;
	}

}
