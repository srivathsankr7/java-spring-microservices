package com.event.ticketmanagement.service;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.event.ticketmanagement.model.Event;
import com.event.ticketmanagement.model.Ticket;
import com.event.ticketmanagement.repository.TicketRepository;

@Service
public class TicketServiceImpl implements TicketService {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private TicketRepository ticketRepository;

	@Override
	public List<Event> getAvailableEvents() {
		Event[] events = restTemplate.getForObject(URI.create("http://eventmanagement-ws/events"), Event[].class);
		return Arrays.asList(events);
	}

	@Override
	public boolean bookTickets(Ticket ticket) {
		Event event = restTemplate.getForObject(URI.create("http://eventmanagement-ws/events/" + ticket.getEventId()),
				Event.class);
		int noOfTickets = ticket.getUsers().size();
		int noOfSeats = event.getSeats();
		if (noOfSeats >= noOfTickets) {
			event.setSeats(noOfSeats - noOfTickets);
			HttpEntity<Event> eventEntity = new HttpEntity<Event>(event);
			restTemplate.exchange(URI.create("http://eventmanagement-ws/events/" + ticket.getEventId()), HttpMethod.PUT,
					eventEntity, Void.class);
			ticketRepository.addTicket(ticket);
			return true;
		}
		return false;
	}

	@Override
	public List<Ticket> getTickets() {
		return ticketRepository.getTickets();
	}

	@Override
	public Ticket getTicket(int ticketId) {
		return ticketRepository.getTicket(ticketId);
	}

}
