package dev.manfertej.yagm.repository;

import dev.manfertej.yagm.model.entity.Exercise;
import dev.manfertej.yagm.model.entity.Muscle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExerciseRepository extends JpaRepository<Exercise, Long> {

	public List<Exercise> findByMuscle(Muscle muscle);
	public List<Exercise> findByMuscleIn(List<Muscle> muscle);
}
