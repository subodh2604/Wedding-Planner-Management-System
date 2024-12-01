package com.wedding.payment.serviceImpls;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wedding.payment.dtos.PaymentDto;
import com.wedding.payment.entities.Payment;
import com.wedding.payment.repositories.PaymentRepository;
import com.wedding.payment.services.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService{
	
	@Autowired
	private PaymentRepository paymentRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public PaymentDto register(PaymentDto paymentDto) {
		
		Payment payment=modelMapper.map(paymentDto, Payment.class);
		
		Payment savedPayment=paymentRepository.save(payment);
		
		PaymentDto savePaymentDto=modelMapper.map(savedPayment, PaymentDto.class);
		
		return savePaymentDto;
	}

	@Override
	public PaymentDto findByPaymentId(int paymentId) {
		Payment payment=paymentRepository.findById(paymentId).orElseThrow(()->new RuntimeException("Payment not found!!!!"));
		
		PaymentDto savePaymentDto=modelMapper.map(payment, PaymentDto.class);
		
		return savePaymentDto;
	}

	@Override
	public List<PaymentDto> findByStatus(String status) {
		List<Payment> payments=paymentRepository.findByStatus(status);
		
		List<PaymentDto> filteredPaymentDtos=new ArrayList();
		
		filteredPaymentDtos=payments.stream().map((x)->modelMapper.map(x,PaymentDto.class)).collect(Collectors.toList());

		return filteredPaymentDtos;
	}

	
	

}
