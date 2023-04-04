package com.capgeticketevents.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgeticketevents.model.Event;
import com.capgeticketevents.repository.EventRepository;


@Service
public class EventServiceImpl implements EventService{

	@Autowired
	private EventRepository eventRepository;
	
	/**
	 * Metodo save Event
	 */
	@Override
	public Event addEvent(Event event){
		return eventRepository.save(event);	
	}
}
