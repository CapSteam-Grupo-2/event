package com.capgeticketevents.service;

import com.capgeticketevents.errorcontrol.NullRequest;
import com.capgeticketevents.model.Event;
import com.capgeticketevents.repository.EventRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventServiceImpl implements EventService {

	@Autowired
	EventRepository eventRepository;

	/**
	 * Metodo que usa EventRepository save para sumar el objeto Event a la base de datos
	 */
	@Override
	public Event addEvent(Event event) {
		return eventRepository.save(event);
	}
	
	@Override
	public  List<Event> listEvent(){
		if(eventRepository.findAll().isEmpty()) {
			throw new  NullRequest();
		}
		return eventRepository.findAll();
	}
}
