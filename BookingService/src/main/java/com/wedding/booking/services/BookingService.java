package com.wedding.booking.services;

import java.time.LocalDate;
import java.util.List;

import com.wedding.booking.dtos.BookingDto;

public interface BookingService {
	public BookingDto register(BookingDto clientDto);

	public BookingDto findByBookingId
	(int clientId);
	
	public String deleteBooking(int bookingId);
}
