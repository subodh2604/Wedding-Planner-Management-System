package com.wedding.vendor.dtos;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VendorAvailabilityDto {
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate availableFrom;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate availableTo;

	private String availabilityStatus;
}
