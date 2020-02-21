package com.event.ticketmanagement.service;

import java.util.List;

import com.event.ticketmanagement.model.Event;
import com.event.ticketmanagement.model.Ticket;

public interface TicketService {
	
	public List<Event> getAvailableEvents();
	
	public boolean bookTickets(Ticket ticket);

	public List<Ticket> getTickets();
	
	public Ticket getTicket(int ticketId);
}
