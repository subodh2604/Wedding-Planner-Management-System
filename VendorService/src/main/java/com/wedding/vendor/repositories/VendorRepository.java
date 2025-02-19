package com.wedding.vendor.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.wedding.vendor.entities.Vendor;

public interface VendorRepository extends JpaRepository<Vendor, Integer> {
	
	@Query(value = "SELECT * FROM Clients c WHERE " +
			"(:weddingDate IS NULL OR c.wedding_date = :weddingDate) AND " +
			"(:minBudget IS NULL OR c.budget >= :minBudget) AND " +
			"(:maxBudget IS NULL OR c.budget <= :maxBudget)",
			nativeQuery = true)
	List<Vendor> findByBudgetRangeOrDate(LocalDate weddingDate, Double minBudget, Double maxBudget);

}
