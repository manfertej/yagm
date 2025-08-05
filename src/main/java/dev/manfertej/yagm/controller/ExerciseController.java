package dev.manfertej.yagm.controller;

import dev.manfertej.yagm.common.exception.BadRequestException;
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


	@GetMapping("/muscles")
	public ResponseEntity<List<Exercise>> getByMuscles(@RequestParam List<Muscle> muscle) {

		var list = exerciseService.getByMuscles(muscle);

		return ResponseEntity.ok(list);
	}



	@ExceptionHandler(BadRequestException.class)
	public ResponseEntity<String> invalidMuscle(BadRequestException exception) {
		return ResponseEntity
			.badRequest()
			.body(exception.getMessage());
	}

}
