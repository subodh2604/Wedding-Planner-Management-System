package com.wedding.payment.services;

import java.util.List;

import com.wedding.payment.dtos.PaymentDto;

public interface PaymentService {
	public PaymentDto register(PaymentDto paymentDto);

	public PaymentDto findByPaymentId(int paymentId);
	
	public List<PaymentDto> findByStatus(String status);


}
