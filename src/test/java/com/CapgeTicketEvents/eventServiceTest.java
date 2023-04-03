package com.CapgeTicketEvents;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.CapgeTicketEvents.model.Event;
import com.CapgeTicketEvents.repository.EventRepository;
import com.CapgeTicketEvents.service.EventService;
import com.CapgeTicketEvents.service.EventServiceImpl;

@WebMvcTest(EventServiceImpl.class)
public class eventServiceTest {

	@Autowired
	private EventService service;
	@MockBean
	private EventRepository repository;

	@Test
	public void addEventTest_OK() {

		Event event = new Event(10L, "jose", "concierto", "pop", "12-12-12", "17:00", null);
		Mockito.when(repository.save(event)).thenReturn(event);
		//Event eventDB = repository.findById(event.getId()).get();
		assertThat(service.addEvent(event)).isNotNull();

	}



}
