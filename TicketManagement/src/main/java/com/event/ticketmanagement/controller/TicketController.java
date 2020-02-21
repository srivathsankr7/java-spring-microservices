package com.event.ticketmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.event.ticketmanagement.model.Event;
import com.event.ticketmanagement.model.Ticket;
import com.event.ticketmanagement.service.TicketService;

@RestController
public class TicketController {
	
	@Autowired
	private TicketService ticketService;

	@GetMapping("/")
	public ResponseEntity<String> ticket() {
		return new ResponseEntity<String>("working", HttpStatus.OK);
	}
	
	@GetMapping("/events")
	public ResponseEntity<List<Event>> getAvailableEvents() {
		return new ResponseEntity<List<Event>>(ticketService.getAvailableEvents(), HttpStatus.FOUND);
	}
	
	
	@PostMapping("/tickets")
	public ResponseEntity<String> bookTickets(@RequestBody Ticket ticket) {
		boolean ticketStatus = ticketService.bookTickets(ticket);
		if(ticketStatus) {
			return new ResponseEntity<String>("Tickets booked successfully", HttpStatus.CREATED);
		} else {
			return new ResponseEntity<String>("Ticket booking failed", HttpStatus.OK);
		}
	}
	
	@GetMapping("tickets")
	public ResponseEntity<List<Ticket>> getTickets() {
		List<Ticket> tickets = ticketService.getTickets();
		return new ResponseEntity<List<Ticket>>(tickets, HttpStatus.FOUND);
	}
	
	@GetMapping("tickets/{ticketId}")
	public ResponseEntity<Ticket> getTicket(@PathVariable("ticketId") int ticketId) {
		Ticket ticket = ticketService.getTicket(ticketId);
		return new ResponseEntity<Ticket>(ticket, HttpStatus.FOUND);
	}
}
