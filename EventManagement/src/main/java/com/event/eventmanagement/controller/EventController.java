package com.event.eventmanagement.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.event.eventmanagement.model.Event;
import com.event.eventmanagement.service.EventService;

@RestController
public class EventController {
	
	@Autowired
	private EventService eventService;

	
	@RequestMapping("/")
	public ResponseEntity<String> event() {
		return new ResponseEntity<String>("working", HttpStatus.OK);
	}
	
	@GetMapping("/events")
	public ResponseEntity<List<Event>> getEvents() {
		return new ResponseEntity<List<Event>>(eventService.getEvents(), HttpStatus.FOUND);
	}

	@GetMapping("/events/{eventId}")
	public ResponseEntity<Event> getEvent(@PathVariable("eventId") int eventId) {
		return new ResponseEntity<Event>(eventService.getEvent(eventId), HttpStatus.FOUND);
	}
	
	@PostMapping("/events/")
	public ResponseEntity<Event> addEvent(@RequestBody List<Event> event) {
		eventService.addEvent(event);
		return new ResponseEntity<Event>(HttpStatus.CREATED);
	}
	
	@PutMapping("/events/{eventId}")
	public ResponseEntity<Event> updateEvent(@PathVariable("eventId") int eventId, @RequestBody Event event) {
		eventService.updateEvent(eventId, event);
		return new ResponseEntity<Event>(HttpStatus.OK);
	}
	
	@DeleteMapping("/events/{eventId}")
	public ResponseEntity<Event> deleteEvent(@PathVariable("eventId") int eventId) {
		eventService.deleteEvent(eventId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
