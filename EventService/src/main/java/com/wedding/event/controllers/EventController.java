package com.wedding.event.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wedding.event.dtos.EventDto;
import com.wedding.event.services.EventService;

@RestController
@RequestMapping("/events")
public class EventController {
	
	@Autowired
	private EventService EventService;
	
	@PostMapping("/")
	public ResponseEntity<EventDto> register(@RequestBody EventDto EventDto)
	{
		
		EventDto savedEventDto=EventService.addEvent(EventDto);
		
		
		return new ResponseEntity<>(savedEventDto,HttpStatus.CREATED);
		
	}
	
	@GetMapping("/{eventId}")
	public ResponseEntity<EventDto> findByEventId(@PathVariable("eventId") int eventId)
	{
		
		EventDto savedEventDto=EventService.findByEventId(eventId);
		
		
		return new ResponseEntity<>(savedEventDto,HttpStatus.OK);
		
	}
	
	@GetMapping("/eventstatus/{status}")
	public ResponseEntity<List<EventDto>> findByEventStatus(@PathVariable("status") String status)
	{
		
		List<EventDto> savedEventDtos=EventService.findByEventStatus(status);
		
		
		return new ResponseEntity<>(savedEventDtos,HttpStatus.OK);
		
	}
}
