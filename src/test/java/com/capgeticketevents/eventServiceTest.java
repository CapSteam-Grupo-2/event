package com.capgeticketevents;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.capgeticketevents.model.Event;
import com.capgeticketevents.repository.EventRepository;
import com.capgeticketevents.service.EventService;
import com.capgeticketevents.service.EventServiceImpl;

@WebMvcTest(EventServiceImpl.class)
public class eventServiceTest {

	@Autowired
	private EventService service;
	@MockBean
	private EventRepository repository;

	
	//Test para comprobar si es null el metodo de addEvent
	@Test
	public void addEventTest_isNotNull() {

		Event event = new Event(10L, "jose", "concierto", "pop", "12-12-12", "17:00", null);
		Mockito.when(repository.save(event)).thenReturn(event);
		//Event eventDB = repository.findById(event.getId()).get();
		assertThat(service.addEvent(event)).isNotNull();
	}



}
