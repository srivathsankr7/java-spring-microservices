package com.event.ticketmanagement.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.event.ticketmanagement.model.Ticket;

@Repository
public class TicketRepositoryImpl implements TicketRepository {

	List<Ticket> ticketList;

	public TicketRepositoryImpl() {
		ticketList = new ArrayList<Ticket>();
	}

	@Override
	public List<Ticket> getTickets() {
		return ticketList;
	}

	@Override
	public Ticket getTicket(int ticketId) {
		return ticketList.stream().filter(ticket -> ticket.getTicketId() == ticketId).findFirst().get();
	}

	@Override
	public void addTicket(Ticket ticket) {
		ticketList.add(ticket);
	}

}
