package dev.manfertej.yagm.controller;

import dev.manfertej.yagm.common.exception.ResourceConflictException;
import dev.manfertej.yagm.common.exception.ResourceNotFoundException;
import dev.manfertej.yagm.common.properties.ApplicationMessages;
import dev.manfertej.yagm.model.dto.ClientDTO;
import dev.manfertej.yagm.model.entity.Client;
import dev.manfertej.yagm.model.mapper.ClientMapper;
import dev.manfertej.yagm.service.ClientService;
import jakarta.validation.UnexpectedTypeException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/clients")
public class ClientController {

	private final ClientService clientService;
	private final ApplicationMessages applicationMessages;


	@GetMapping("/{id}")
	public ResponseEntity<ClientDTO> getByID(@PathVariable("id") Long id) {
		// Client instead of Optional<Client> because this is not a search
		ClientDTO client = ClientMapper.toDTO(clientService.getByID(id));
		return ResponseEntity.ok(client);
	}


	@PostMapping("/register")
	public ResponseEntity<String> register(@Valid @RequestBody ClientDTO client) {

		clientService.register(ClientMapper.toEntity(client));

		return ResponseEntity.ok(applicationMessages.getClientRegistered());
	}



	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<String> ClientDoNotExists(ResourceNotFoundException ex) {
		return ResponseEntity
			.status(ex.getHttpStatus())
			.body(ex.getMessage());
	}

	@ExceptionHandler(ResourceConflictException.class)
	public ResponseEntity<String> ClientAlreadyExists(ResourceConflictException ex) {
		return ResponseEntity
			.status(ex.getHttpStatus())
			.body(ex.getMessage());
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<String> invalidClientData(MethodArgumentNotValidException ex) {
		return ResponseEntity
			.status(HttpStatus.CONFLICT)
			.body(applicationMessages.getInvalidClientData());
	}

}
