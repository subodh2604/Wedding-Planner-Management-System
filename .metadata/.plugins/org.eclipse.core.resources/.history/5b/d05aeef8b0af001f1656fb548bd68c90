package com.wedding.client.services;

import java.time.LocalDate;
import java.util.List;

import com.wedding.client.dtos.ClientDto;

public interface ClientService {
	public ClientDto register(ClientDto clientDto);

	public ClientDto findByClientId(int clientId);

	public List<ClientDto> findByBudgetOrDate(LocalDate weddingDate, Double minBudget, Double maxBudget);
}
