package com.wedding.vendor.dtos;

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
public class VendorDto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int vendorId;
	
	private String vendorName;
	
	private String email;
	
	private String phone;
	
	private String serviceType;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate availableFrom;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate availableTo;

	private String availabilityStatus;
}
