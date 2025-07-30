package dev.manfertej.yagm.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.manfertej.yagm.common.exception.ResourceNotFoundException;
import dev.manfertej.yagm.common.properties.ClientMessages;
import dev.manfertej.yagm.model.dto.ClientDTO;
import dev.manfertej.yagm.model.entity.Client;
import dev.manfertej.yagm.model.mapper.ClientMapper;
import dev.manfertej.yagm.service.ClientService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(controllers = ClientController.class)
@AutoConfigureMockMvc
@DisplayName("Client Controller tests")
public class ClientControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockitoBean
	private ClientService clientService;


	@Test
	void returnClientIfExists() throws Exception{
		Client client = Client.builder()
			.ID(50L)
			.firstName("Antonio")
			.lastName("García")
			.email("Antonio@Garcia.com")
			.phoneNumber(987665443)
			.dni("12345678L")
			.build();

		when(this.clientService.getByID(50L)).thenReturn(client);

		mockMvc.perform(get("/api/v1/clients/50"))
			.andExpectAll(
				status().isOk(),
				jsonPath("$.id").value(50L),
				jsonPath("$.firstName").value("Antonio"),
				jsonPath("$.lastName").value("García"),
				jsonPath("$.email").value("Antonio@Garcia.com"),
				jsonPath("$.phoneNumber").value(987665443)
			);

	}

	// Try to get a client that does not exist
	@Test
	void errorIfDoNotExists() throws Exception {

		when(this.clientService.getByID(50L)).thenThrow(
			new ResourceNotFoundException(ClientMessages.DOES_NOT_EXISTS));

		mockMvc.perform(get("/api/v1/clients/50"))
			.andExpect(status().is4xxClientError());
	}


	@Test
	void okIfRegisteredSuccessfully() throws Exception {
		ClientDTO client = ClientDTO.builder()
			.ID(50L)
			.firstName("Antonio")
			.lastName("García")
			.email("Antonio@Garcia.com")
			.phoneNumber(987665443)
			.dni("12345678L")
			.build();

		when(clientService.register(ClientMapper.toEntity(client))).thenReturn(null);

		ObjectMapper objectMapper = new ObjectMapper();

		mockMvc.perform(post("/api/v1/clients/register")
			.contentType(MediaType.APPLICATION_JSON)
			.content(objectMapper.writeValueAsString(client)))
			.andExpect(status().isOk());
	}



	@Test
	void invalidDataToRegister() throws Exception {

		//Client with invalid DNI
		ClientDTO client = ClientDTO.builder()
			.ID(50L)
			.firstName("Antonio")
			.lastName("García")
			.email("Antonio@Garcia.com")
			.phoneNumber(987665443)
			.dni("12345678")
			.build();

		ObjectMapper objectMapper = new ObjectMapper();

		mockMvc.perform(post("/api/v1/clients/register")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(client)))
			.andExpect(status().isConflict());

	}


}
