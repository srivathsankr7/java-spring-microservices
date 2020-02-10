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
	public List<Event> getEvents() {
		return eventService.getEvents();
	}

	@GetMapping("/events/{eventId}")
	public Event getEvent(@PathVariable("eventId") int eventId) {
		return eventService.getEvent(eventId);
	}
	
	@PostMapping("/events/")
	public void addEvent(@RequestBody Event event) {
		eventService.addEvent(event);
	}
	
	@PutMapping("/events/{eventId}")
	public void updateEvent(@PathVariable("eventId") int eventId, @RequestBody Event event) {
		eventService.updateEvent(eventId, event);
	}
	
	@DeleteMapping("/events/{eventId}")
	public void deleteEvent(@PathVariable("eventId") int eventId) {
		eventService.deleteEvent(eventId);
	}
	
}
