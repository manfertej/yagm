package dev.manfertej.yagm.controller;

import dev.manfertej.yagm.common.exception.ResourceConflictException;
import dev.manfertej.yagm.common.exception.ResourceNotFoundException;
import dev.manfertej.yagm.common.messages.ClientMessages;
import dev.manfertej.yagm.model.dto.ClientDTO;
import dev.manfertej.yagm.model.mapper.ClientMapper;
import dev.manfertej.yagm.service.ClientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/clients")
public class ClientController {

	private final ClientService clientService;


	@GetMapping("/{id}")
	public ResponseEntity<ClientDTO> getByID(@PathVariable("id") Long id) {
		// Client instead of Optional<Client> because this is not a search
		ClientDTO client = ClientMapper.toDTO(clientService.getByID(id));
		return ResponseEntity.ok(client);
	}


	@PostMapping("/register")
	public ResponseEntity<String> register(@Valid @RequestBody ClientDTO client) {

		clientService.register(ClientMapper.toEntity(client));

		return ResponseEntity.ok(ClientMessages.REGISTERED);
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
			.body(ClientMessages.INVALID_DATA);
	}

}
