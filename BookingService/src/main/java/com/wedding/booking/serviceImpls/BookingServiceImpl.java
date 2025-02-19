package com.wedding.booking.serviceImpls;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wedding.booking.dtos.BookingDto;
import com.wedding.booking.entities.Booking;
import com.wedding.booking.repositories.BookingRepository;
import com.wedding.booking.services.BookingService;

@Service
public class BookingServiceImpl implements BookingService{
	
	@Autowired
	private BookingRepository bookingRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public BookingDto register(BookingDto bookingDto) {
		
		Booking booking=modelMapper.map(bookingDto, Booking.class);
		
		Booking savedBooking=bookingRepository.save(booking);
		
		BookingDto saveBookingDto=modelMapper.map(savedBooking, BookingDto.class);
		
		return saveBookingDto;
	}

	@Override
	public BookingDto findByBookingId(int bookingId) {
		Booking booking=bookingRepository.findById(bookingId).orElseThrow(()->new RuntimeException("Booking not found!!!!"));
		
		BookingDto saveBookingDto=modelMapper.map(booking, BookingDto.class);
		
		return saveBookingDto;
	}

	@Override
	public String deleteBooking(int bookingId) {
		bookingRepository.deleteById(bookingId);
		return "Booking deleted successfully!!!!";
	}

	

}
