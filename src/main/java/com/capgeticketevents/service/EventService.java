package com.capgeticketevents.service;

import java.util.List;



import com.capgeticketevents.model.Event;

public interface EventService {

    //Para add event
    public Event addEvent(Event event);
    
    //Para listar los eventos
    public List<Event> listEvent();
}
