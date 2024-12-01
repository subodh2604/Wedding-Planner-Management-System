package com.wedding.client.serviceImpls;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wedding.client.dtos.ClientDto;
import com.wedding.client.entities.Client;
import com.wedding.client.repositories.ClientRepository;
import com.wedding.client.services.ClientService;

@Service
public class ClientServiceImpl implements ClientService{
	
	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public ClientDto register(ClientDto clientDto) {
		
		Client client=modelMapper.map(clientDto, Client.class);
		
		Client savedClient=clientRepository.save(client);
		
		ClientDto saveClientDto=modelMapper.map(savedClient, ClientDto.class);
		
		return saveClientDto;
	}

	@Override
	public ClientDto findByClientId(int clientId) {
		Client client=clientRepository.findById(clientId).orElseThrow(()->new RuntimeException("Client not found!!!!"));
		
		ClientDto saveClientDto=modelMapper.map(client, ClientDto.class);
		
		return saveClientDto;
	}

	@Override
	public List<ClientDto> findByBudgetOrDate(LocalDate weddingDate, Double minBudget, Double maxBudget) {
		List<Client> filteredClients=clientRepository.findByBudgetRangeOrDate(weddingDate,minBudget,maxBudget);
		
		List<ClientDto> filteredClientDtos=new ArrayList<>();
		
		filteredClientDtos=filteredClients.stream().map((x)->modelMapper.map(x,ClientDto.class)).collect(Collectors.toList());
		
		return filteredClientDtos;
	}

}
