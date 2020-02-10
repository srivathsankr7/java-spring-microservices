package com.event.eventmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.event.eventmanagement.model.Event;
import com.event.eventmanagement.repository.EventRepository;

@Service
public class EventServiceImpl implements EventService{

	@Autowired
	private EventRepository eventRepository;
	
	@Override
	public List<Event> getEvents() {		
		return eventRepository.getEvents();
	}

	@Override
	public Event getEvent(int eventId) {
		return eventRepository.getEvent(eventId);
	}

	@Override
	public void addEvent(List<Event> event) {
		eventRepository.addEvent(event);
		
	}

	@Override
	public void updateEvent(int eventId, Event event) {
		eventRepository.updateEvent(eventId, event);
	}

	@Override
	public void deleteEvent(int eventId) {
		eventRepository.deleteEvent(eventId);
	}
}
