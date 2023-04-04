package com.capgeticketevents.service;

import org.springframework.stereotype.Service;

import com.capgeticketevents.model.Event;

public interface EventService {

    //Para add event
    public Event addEvent(Event event);
}
