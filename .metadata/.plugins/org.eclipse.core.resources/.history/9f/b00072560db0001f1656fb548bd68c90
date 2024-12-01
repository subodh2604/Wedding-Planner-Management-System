package com.wedding.client.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.wedding.client.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Integer> {
	
	@Query(value = "SELECT * FROM Clients c WHERE " +
			"(:weddingDate IS NULL OR c.wedding_date = :weddingDate) AND " +
			"(:minBudget IS NULL OR c.budget >= :minBudget) AND " +
			"(:maxBudget IS NULL OR c.budget <= :maxBudget)",
			nativeQuery = true)
	List<Client> findByBudgetRangeOrDate(LocalDate weddingDate, Double minBudget, Double maxBudget);

}
