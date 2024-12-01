package com.wedding.booking.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.wedding.booking.entities.Booking;

public interface BookingRepository extends JpaRepository<Booking, Integer> {
	
	@Query(value = "SELECT * FROM Bookings c WHERE " +
			"(:weddingDate IS NULL OR c.wedding_date = :weddingDate) AND " +
			"(:minBudget IS NULL OR c.budget >= :minBudget) AND " +
			"(:maxBudget IS NULL OR c.budget <= :maxBudget)",
			nativeQuery = true)
	List<Booking> findByBudgetRangeOrDate(LocalDate weddingDate, Double minBudget, Double maxBudget);

}
