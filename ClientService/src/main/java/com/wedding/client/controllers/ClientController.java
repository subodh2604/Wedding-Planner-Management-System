package com.wedding.client.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wedding.client.dtos.ClientDto;
import com.wedding.client.services.ClientService;

@RestController
@RequestMapping("/clients")
public class ClientController {
	
	@Autowired
	private ClientService clientService;
	
	@PostMapping("/")
	public ResponseEntity<ClientDto> register(@RequestBody ClientDto clientDto)
	{
		
		ClientDto savedClientDto=clientService.register(clientDto);
		
		
		return new ResponseEntity<>(savedClientDto,HttpStatus.CREATED);
		
	}
	
	@GetMapping("/{clientId}")
	public ResponseEntity<ClientDto> findByClientId(@PathVariable("clientId") int clientId)
	{
		
		ClientDto savedClientDto=clientService.findByClientId(clientId);
		
		
		return new ResponseEntity<>(savedClientDto,HttpStatus.OK);
		
	}
	
	@GetMapping("")
	public ResponseEntity<List<ClientDto>> findByBudgetOrDate(@RequestParam(required = false,name = "weddingDate") @DateTimeFormat(pattern = "yyyy-mm-dd") LocalDate weddingDate,
			@RequestParam(required = false,name = "minBudget") Double minBudget,@RequestParam(required = false,name = "maxBudget") Double maxBudget)
	{
		
		List<ClientDto> savedClientDtos=clientService.findByBudgetOrDate(weddingDate,minBudget,maxBudget);
		
		
		return new ResponseEntity<>(savedClientDtos,HttpStatus.OK);
		
	}
}
