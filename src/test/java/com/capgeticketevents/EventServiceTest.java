package com.capgeticketevents;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.capgeticketevents.model.Event;
import com.capgeticketevents.repository.EventRepository;
import com.capgeticketevents.service.EventService;
import com.capgeticketevents.service.EventServiceImpl;

@WebMvcTest(EventServiceImpl.class)
public class EventServiceTest {

	@Autowired
	private EventService service;
	@MockBean
	private EventRepository repository;

	
	/**
	 * Test que comprueba los valores de Event del servicio
	 */
	@Test
	public void addEventTest_OK() {

		Event event = new Event(10L, "jose", "concierto", "pop", "12-12-12", "17:00", null);
		repository.save(event);
		Event eventDB = repository.findById(event.getId()).get();
		assertThat(eventDB).isNotNull();
	}

	@Test
	public void addUserTest_AlreadyExists() {
		Event event = new Event(10L, "jose", "concierto", "pop", "12-12-12", "17:00", null);
		// Mockito.when(repository.existsByMail(user.getMail())).thenReturn(true);

		assertThat(service.addEvent(event)).isEqualTo(Optional.empty());
	}

}
