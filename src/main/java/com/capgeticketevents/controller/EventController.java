package com.capgeticketevents.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgeticketevents.converter.EventConverter;
import com.capgeticketevents.errorcontrol.NullRequest;
import com.capgeticketevents.model.Event;
import com.capgeticketevents.model.Location;
import com.capgeticketevents.repository.LocationRepository;

import com.capgeticketevents.service.EventService;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/event")
public class EventController {

	@Autowired
	EventService service;
	
	@Autowired
	LocationRepository locationRepository;
	
	//@Autowired
	//EventConverter converter;
	
	
	
	// Vamos a indicar algunos elementos de OPenAPI
	@Operation(
			summary = "Añadir Eventos a la DDBB", 
			description = "introducir los parametros id,name,type,description,date,time,location", 
			tags= {"Event"})
	@ApiResponses(value = {
			@ApiResponse(
					responseCode = "200", 
					description = "Evento creado", 
					content = {
							@Content(
									mediaType = "application/json", 
									schema = @Schema(
											implementation = Event.class)
									) 
							}
					),
			@ApiResponse(
					responseCode = "400", 
					description = "No válido (Campos no validos o faltantes) ", 
					content = @Content),
			}
	)	
	/**
	 * @param event Metodo para guardar eventos
	 * @return los datos de event con estatus 200 si no hay error
	 */
	@PostMapping("/new")
	public ResponseEntity<Event> addEvent(@Valid @RequestBody Event event) {
				
		List<Event> locationList = new ArrayList<>();
		locationList.add(event);
		Location location = new Location(1, "mostoles","3","madrid","ifema","music",locationList);
		
		
		locationRepository.save(location);
		
		var result = this.service.addEvent(event);
		result.setLocation(location);
		

		return ResponseEntity.ok( result );

	}
	

	@Operation(
			summary = "Listar Eventos de la DDBB", 
			description = "Lista los todos los eventos", 
			tags= {"Event"})
	@ApiResponses(value = {
			@ApiResponse(
					responseCode = "200", 
					description = "Evento creado", 
					content = {
							@Content(
									mediaType = "application/json", 
									schema = @Schema(
											implementation = Event.class)
									) 
							}
					),
			@ApiResponse(
					responseCode = "400", 
					description = "No data found", 
					content = @Content),
			}
	)
	@GetMapping("/list")
	public ResponseEntity<Collection<Event>> listEvent() {

		Collection<Event> event = service.listEvent();

		// si event = null;
		if (event.isEmpty()|| event==null) {
			throw new  NullRequest();
		}

		return ResponseEntity.ok(event);

	}
}
