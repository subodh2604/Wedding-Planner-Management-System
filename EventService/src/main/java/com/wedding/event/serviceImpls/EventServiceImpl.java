package com.wedding.event.serviceImpls;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wedding.event.dtos.EventDto;
import com.wedding.event.entities.Event;
import com.wedding.event.repositories.EventRepository;
import com.wedding.event.services.EventService;

@Service
public class EventServiceImpl implements EventService{
	
	@Autowired
	private EventRepository EventRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public EventDto addEvent(EventDto EventDto) {
		
		Event Event=modelMapper.map(EventDto, Event.class);
		
		Event savedEvent=EventRepository.save(Event);
		
		EventDto saveEventDto=modelMapper.map(savedEvent, EventDto.class);
		
		return saveEventDto;
	}

	@Override
	public EventDto findByEventId(int EventId) {
		Event Event=EventRepository.findById(EventId).orElseThrow(()->new RuntimeException("Event not found!!!!"));
		
		EventDto saveEventDto=modelMapper.map(Event, EventDto.class);
		
		return saveEventDto;
	}

	@Override
	public List<EventDto> findByEventStatus(String status) {
		List<Event> filteredEvents=EventRepository.findByStatus(status);
		
		List<EventDto> filteredEventDtos=new ArrayList<>();
		
		filteredEventDtos=filteredEvents.stream().map((x)->modelMapper.map(x,EventDto.class)).collect(Collectors.toList());
		
		return filteredEventDtos;
	}

}
