package com.capgeticketevents.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgeticketevents.model.Event;
import com.capgeticketevents.service.EventService;

import jakarta.validation.Valid;



@RestController
@RequestMapping("/event")
public class EventController {

	@Autowired
	EventService service;
	
	
	/**
	 * 
	 * @param event
	 * Metodo para guardar eventos
	 * @return los datos de event con estatus 200 si no hay error
	 */
	@PostMapping("/new")
	public ResponseEntity<Event> addEvent(@Valid @RequestBody Event event){
		

		var result = this.service.addEvent(event);
		return ResponseEntity.ok(result);
		
	}


}
