package com.wedding.booking.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wedding.booking.dtos.BookingDto;
import com.wedding.booking.services.BookingService;

@RestController
@RequestMapping("/bookings")
public class BookingController {
	
	@Autowired
	private BookingService bookingService;
	
	@PostMapping("/")
	public ResponseEntity<BookingDto> register(@RequestBody BookingDto clientDto)
	{
		
		BookingDto savedBookingDto=bookingService.register(clientDto);
		
		
		return new ResponseEntity<>(savedBookingDto,HttpStatus.CREATED);
		
	}
	
	@GetMapping("/{bookingId}")
	public ResponseEntity<BookingDto> findByClientId(@PathVariable("bookingId") int bookingId)
	{
		
		BookingDto savedBookingDto=bookingService.findByBookingId(bookingId);
		
		
		return new ResponseEntity<>(savedBookingDto,HttpStatus.OK);
		
	}
	
	@DeleteMapping("/bookings/{bookingId}/cancel")
	public ResponseEntity<String> findByBudgetOrDate(@PathVariable("bookingId") int bookingId)
	{
		
		String status=bookingService.deleteBooking(bookingId);
		
		
		return new ResponseEntity<>(status,HttpStatus.OK);
		
	}
}
