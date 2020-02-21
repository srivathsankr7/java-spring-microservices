package com.event.ticketmanagement.repository;

import java.util.List;

import com.event.ticketmanagement.model.Ticket;

public interface TicketRepository {
	
	public void addTicket(Ticket ticket);

	public List<Ticket> getTickets();
	
	public Ticket getTicket(int ticketId);
	
}
