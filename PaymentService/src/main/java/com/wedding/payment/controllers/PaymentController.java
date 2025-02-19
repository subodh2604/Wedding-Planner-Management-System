package com.wedding.payment.controllers;

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

import com.wedding.payment.dtos.PaymentDto;
import com.wedding.payment.services.PaymentService;

@RestController
@RequestMapping("/payments")
public class PaymentController {
	
	@Autowired
	private PaymentService paymentService;
	
	@PostMapping("/")
	public ResponseEntity<PaymentDto> register(@RequestBody PaymentDto paymentDto)
	{
		
		PaymentDto savedPaymentDto=paymentService.register(paymentDto);
		
		
		return new ResponseEntity<>(savedPaymentDto,HttpStatus.CREATED);
		
	}
	
	@GetMapping("/{paymentId}")
	public ResponseEntity<PaymentDto> findByClientId(@PathVariable("paymentId") int paymentId)
	{
		
		PaymentDto savedPaymentDto=paymentService.findByPaymentId(paymentId);
		
		
		return new ResponseEntity<>(savedPaymentDto,HttpStatus.OK);
		
	}
	
	@GetMapping("")
	public ResponseEntity<List<PaymentDto>> findByStatus(
			@RequestParam(required = false,name = "status") String status)
	{
		
		List<PaymentDto> savedPaymentDtos=(List<PaymentDto>) paymentService.findByStatus(status);
		
		
		return new ResponseEntity<>(savedPaymentDtos,HttpStatus.OK);
		
	}
}
