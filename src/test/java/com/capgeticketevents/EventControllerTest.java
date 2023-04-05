package com.capgeticketevents;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import com.capgeticketevents.controller.EventController;
import com.capgeticketevents.model.Event;
import com.capgeticketevents.model.Location;
import com.capgeticketevents.service.EventService;

import jakarta.validation.Valid;
import jakarta.ws.rs.BadRequestException;


@WebMvcTest(EventController.class)
public class EventControllerTest {

	@MockBean
	private EventService service;
	
	
	
	/**
	 * Test que comprueba los valores de Event en el controlador
	 */
	@Test
	public void addEventTest_OK() {
		Location location = new Location();
		Event event = new Event(10L, "festival", "concierto", "pop", "12-12-12", "17:00", location);
		Mockito.when(service.addEvent(event)).thenReturn(event);
		assertThat(service.addEvent(event)).isEqualTo(Optional.of(event));
	}
	
    @Test
    public void addEventTest_AlreadyExists() {
    	Location location = new Location();
    	Event event = new Event(10L, "jose", "concierto", "pop", "12-12-12", "17:00", location);
    	Mockito.when(service.addEvent(event)).thenReturn(event);
        assertThat(service.addEvent(event)).isEqualTo(Optional.empty());
    }
    
	@Test
	public void addEventTest_nullName() {
		Location location = new Location();
	    try {
	    	Event eventExpected = new Event(10L, null, "concierto", "pop", "12-12-12", "17:00", location);
	    } catch (Exception e) {
	        throw new BadRequestException(e);
	    }
	}
	@Test
	public void addEventTest_nullType() {
		Location location = new Location();
	    try {
	    	Event eventExpected = new Event(10L, "festival", null, "pop", "12-12-12", "17:00", location);
	    } catch (Exception e) {
	        throw new BadRequestException(e);
	    }
	}
	
}
