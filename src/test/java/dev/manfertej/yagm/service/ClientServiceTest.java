package dev.manfertej.yagm.service;

import dev.manfertej.yagm.common.exception.ResourceConflictException;
import dev.manfertej.yagm.common.exception.ResourceNotFoundException;
import dev.manfertej.yagm.common.properties.ApplicationMessages;
import dev.manfertej.yagm.model.entity.Client;
import dev.manfertej.yagm.repository.ClientRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
@DisplayName("Client Service tests")
public class ClientServiceTest {

	@Mock
	private ClientRepository clientRepository;

	@Mock
	private ApplicationMessages applicationMessages;

	@InjectMocks
	private ClientService clientService;

	//
	@Test
	@Order(1)
	@DisplayName("Existing client is returned")
	void getClientThatExists() {
		Client client = Client.builder()
			.ID(50L)
			.firstName("Antonio")
			.lastName("García")
			.email("Antonio@Garcia.com")
			.phoneNumber(987665443)
			.dni("12345678L")
			.build();

		when(clientRepository.findById(50L)).thenReturn(Optional.ofNullable(client));

		Client result = this.clientService.getByID(50L);

		assertEquals(50L, result.getID());
		assertEquals("Antonio", result.getFirstName());
		assertEquals("García", result.getLastName());
		assertEquals("Antonio@Garcia.com", result.getEmail());
		assertEquals(987665443, result.getPhoneNumber());
		assertEquals("12345678L", result.getDni());
	}


	// A bit insubstantial, but good for the notes.
	@Test
	@Order(2)
	@DisplayName("Get non existent client throws exception")
	void clientNonExistent() {

		Long testID = 50L;

		when(clientRepository.findById(testID))
			.thenReturn(Optional.empty());
		assertThrows(ResourceNotFoundException.class,
			() -> clientService.getByID(testID));
	}


	@Test
	@Order(3)
	@DisplayName("Register new client successfully")
	void registerNewClientOk() {

		Client client = Client.builder()
			.ID(50L)
			.firstName("Antonio")
			.lastName("García")
			.email("Antonio@Garcia.com")
			.phoneNumber(987665443)
			.dni("12345678L")
			.build();

		when(clientRepository.save(client)).thenReturn(client);

		Client result = clientService.register(client);

		assertEquals(50L, result.getID());
		assertEquals("Antonio", result.getFirstName());
		assertEquals("García", result.getLastName());
		assertEquals("Antonio@Garcia.com", result.getEmail());
		assertEquals(987665443, result.getPhoneNumber());
		assertEquals("12345678L", result.getDni());
	}


	@Test
	@Order(4)
	@DisplayName("Register existing client fails")
	void registerExistingClientFails() {

		Client client = Client.builder()
			.ID(50L)
			.firstName("Antonio")
			.lastName("García")
			.email("Antonio@Garcia.com")
			.phoneNumber(987665443)
			.dni("12345678L")
			.build();


		when(clientRepository.existsByDni("12345678L")).thenReturn(true);

		assertThrows(ResourceConflictException.class,
			() -> clientService.register(client));
	}


}
