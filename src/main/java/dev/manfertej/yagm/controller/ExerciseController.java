package dev.manfertej.yagm.controller;

import dev.manfertej.yagm.model.entity.Exercise;
import dev.manfertej.yagm.model.entity.Muscle;
import dev.manfertej.yagm.service.ExerciseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/exercises")
@RequiredArgsConstructor
public class ExerciseController {

	private final ExerciseService exerciseService;


	@GetMapping("/muscle")
	public ResponseEntity<List<Exercise>> getByMuscle(@RequestParam Muscle muscle) {

		var list = exerciseService.getByMuscle(muscle);

		return ResponseEntity.ok(list);
	}


}
