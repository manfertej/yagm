package dev.manfertej.yagm.common.converter;

import dev.manfertej.yagm.model.entity.Muscle;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;


// Convert request param to Muscle enum
@Component
public class StringToMuscleConverter implements Converter<String, Muscle> {

	@Override
	public Muscle convert(String requestParam) {
		return Muscle.fromLabel(requestParam)
			.orElseThrow(() -> new IllegalArgumentException("Invalid muscle: " + requestParam));
	}
}
