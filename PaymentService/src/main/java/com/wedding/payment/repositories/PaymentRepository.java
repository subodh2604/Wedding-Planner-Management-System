package com.wedding.payment.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.wedding.payment.entities.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {

	public List<Payment> findByStatus(String status);
	
}
