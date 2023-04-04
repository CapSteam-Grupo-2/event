package com.capgeticketevents.service;

import com.capgeticketevents.model.Event;
import com.capgeticketevents.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class EventServiceImpl implements EventService {

    @Autowired
    EventRepository eventRepository;

    /**
     * Metodo save Event
     */
    @Override
    public Event addEvent(Event event) {
        return eventRepository.save(event);
    }
}
