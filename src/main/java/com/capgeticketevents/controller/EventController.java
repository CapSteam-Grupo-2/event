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
	
	@PostMapping("/new")
	public ResponseEntity<Event> addEvent(@Valid @RequestBody Event event){
		System.out.println("LOCATION -------------" + event.getLocation());  
		var result = this.service.addEvent(event);
		return ResponseEntity.ok(result);
	}


}
