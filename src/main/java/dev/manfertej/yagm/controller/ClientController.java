package dev.manfertej.yagm.controller;

import dev.manfertej.yagm.model.Client;
import dev.manfertej.yagm.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
@RequestMapping("/clients")
public class ClientController {

	private final ClientService clientService;

	@GetMapping("/{id}")
	public ResponseEntity<Client> getByID(@PathVariable("id") Long id) {
		return ResponseEntity.of(clientService.get(id));
	}


	@PostMapping("/register")
	public ResponseEntity<String> register(@RequestBody Client client) {

		clientService.register(client);

		return new ResponseEntity<>("Client created successfully", HttpStatus.OK);
	}


	@ExceptionHandler()
	public ResponseEntity<String> ClientAlreadyExists(Exception ex) {
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
	}


	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") Long id) {
		return null;
	}

}
