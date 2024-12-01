package com.wedding.payment.dtos;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDto {
	
	private int clientId;
	
	private Double amount;

	private String status;
		
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate paymentDate;
	
}
