package com.CapgeTicketEvents.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.CapgeTicketEvents.model.Event;
import com.CapgeTicketEvents.repository.EventRepository;

public class EventServiceImpl implements EventService{

	@Autowired
	EventRepository eventRepository;
	
	/**
	 * Metodo save Event
	 */
	@Override
	public Event addEvent(Event event){
		return eventRepository.save(event);	
	}
}
