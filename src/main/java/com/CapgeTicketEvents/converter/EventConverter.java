package com.CapgeTicketEvents.converter;

import com.CapgeTicketEvents.model.Event;
import com.CapgeTicketEvents.response.EventResponse;
import com.CapgeTicketEvents.response.LocationResponse;

public class EventConverter {
	
	public EventResponse of (Event event) {
		return EventResponse.builder()
				.id(event.getId())
				.name(event.getName())
				.type(event.getType())
				.date(event.getDate())
				.time(event.getTime())
				.location(LocationResponse.builder()
						.id(event.getLocation().getId())
						.name(event.getLocation().getName())
						.city(event.getLocation().getCity())
						.addres(event.getLocation().getAddres())
						.type(event.getLocation().getType())
						.capacity(event.getLocation().getCapacity())
						.build())
				.build();		
	}
	
	
	


}
