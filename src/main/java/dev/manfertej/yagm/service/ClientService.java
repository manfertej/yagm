package dev.manfertej.yagm.service;


import dev.manfertej.yagm.common.exception.ResourceConflictException;
import dev.manfertej.yagm.common.exception.ResourceNotFoundException;
import dev.manfertej.yagm.common.messages.ClientMessages;
import dev.manfertej.yagm.model.entity.Client;
import dev.manfertej.yagm.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientService {

	private final ClientRepository clientRepository;


	public Client getByID(Long ID) {
		return clientRepository.findById(ID).orElseThrow(() ->
			new ResourceNotFoundException(ClientMessages.DOES_NOT_EXISTS));
	}


	public Client register(Client client) throws ResourceConflictException {

		if(clientRepository.existsByDni(client.getDni()))
			throw new ResourceConflictException(ClientMessages.ALREADY_EXISTS);

		return clientRepository.save(client);
	}

}
