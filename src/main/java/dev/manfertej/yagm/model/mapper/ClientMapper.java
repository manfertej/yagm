package dev.manfertej.yagm.model.mapper;

import dev.manfertej.yagm.model.dto.ClientDTO;
import dev.manfertej.yagm.model.entity.Client;
import org.modelmapper.ModelMapper;

public class ClientMapper {

	public static ClientDTO toDTO(Client client) {

		return new ModelMapper().map(client, ClientDTO.class);
	}

	public static Client toEntity(ClientDTO clientDTO) {

		return new ModelMapper().map(clientDTO, Client.class);
	}


}
