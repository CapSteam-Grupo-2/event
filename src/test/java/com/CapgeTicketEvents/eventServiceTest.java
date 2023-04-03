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
		repository.save(event);
		Event eventDB = repository.findById(event.getId()).get();
		assertThat(eventDB).isNotNull();

		/*
		 * Event event = new Event(10L,"jose","concierto","pop","12-12-12","17:00",
		 * null); //Mockito.when(repository.existsByMail("")).thenReturn(false);
		 * Mockito.when(repository.save(event)).thenReturn(event);
		 * assertThat(service.addEvent(event)).isEqualTo(Optional.of(event));
		 */
	}

	@Test
	public void addUserTest_AlreadyExists() {
		Event event = new Event(10L, "jose", "concierto", "pop", "12-12-12", "17:00", null);
		// Mockito.when(repository.existsByMail(user.getMail())).thenReturn(true);

		assertThat(service.addEvent(event)).isEqualTo(Optional.empty());
	}

}