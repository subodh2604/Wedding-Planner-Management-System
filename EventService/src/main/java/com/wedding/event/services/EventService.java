package com.wedding.event.services;

import java.time.LocalDate;
import java.util.List;

import com.wedding.event.dtos.EventDto;

public interface EventService {
	public EventDto addEvent(EventDto EventDto);

	public EventDto findByEventId(int clientId);

	public List<EventDto> findByEventStatus(String status);
}
