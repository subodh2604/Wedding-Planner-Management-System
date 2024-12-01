package com.wedding.event.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.wedding.event.entities.Event;

public interface EventRepository extends JpaRepository<Event, Integer> {
	
	
	List<Event> findByStatus(String status);

}
