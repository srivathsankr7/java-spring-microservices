package com.event.eventmanagement.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.event.eventmanagement.model.Event;

@Repository
public class EventRepositoryImpl implements EventRepository{

	
	private List<Event> eventList;
	
	
	public EventRepositoryImpl() {
		eventList = new ArrayList<>();
	}

	@Override
	public List<Event> getEvents() {
		return eventList;
	}

	@Override
	public Event getEvent(int eventId) {
		return eventList.stream().filter(event -> event.getEventId() == eventId).findFirst().get();
	}

	@Override
	public void addEvent(List<Event> event) {
		eventList.addAll(event);	
	}

	@Override
	public void updateEvent(int eventId, Event newEvent) {
		Event event = eventList.stream().filter(e -> e.getEventId() == eventId).findFirst().get();
		event.setName(newEvent.getName());
		event.setDescription(newEvent.getDescription());
		event.setPrice(newEvent.getPrice());
	}

	@Override
	public void deleteEvent(int eventId) {
		Event event = eventList.stream().filter(e -> e.getEventId() == eventId).findFirst().get();
		if(event != null) {
			eventList.remove(event);
		}
		
	}
}
