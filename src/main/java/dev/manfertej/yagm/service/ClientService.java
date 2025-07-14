package dev.manfertej.yagm.service;


import dev.manfertej.yagm.common.exception.ResourceConflictException;
import dev.manfertej.yagm.common.exception.ResourceNotFoundException;
import dev.manfertej.yagm.common.properties.ApplicationMessages;
import dev.manfertej.yagm.model.Client;
import dev.manfertej.yagm.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientService {

	private final ClientRepository clientRepository;


	public Optional<Client> get(Long ID) {
		return clientRepository.findById(ID);
	}

	public void delete(Long id) {

		if (!clientRepository.existsById(id))
			throw new ResourceNotFoundException(ApplicationMessages.clientDoesNotExist);

		clientRepository.deleteById(id);
	}


	public void register(Client client) throws ResourceConflictException {

		if(clientRepository.existsById(client.getID()))
			throw new ResourceConflictException(ApplicationMessages.clientAlreadyExists);

		clientRepository.save(client);

		return;
	}

}
