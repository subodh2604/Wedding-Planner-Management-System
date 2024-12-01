package com.wedding.client.dtos;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientDto {
	private int clientId;
	
	private String clientName;
	
	private String email;
	
	private String phone;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate weddingDate;
	
	private Double budget;
}
