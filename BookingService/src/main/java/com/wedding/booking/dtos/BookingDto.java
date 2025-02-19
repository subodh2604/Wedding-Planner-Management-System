package com.wedding.booking.dtos;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.wedding.booking.entities.Event;
import com.wedding.booking.entities.Vendor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingDto {
	private int bookingId;
		
	private int vendorId;
	
	private int clientId;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate bookingDate;
}
