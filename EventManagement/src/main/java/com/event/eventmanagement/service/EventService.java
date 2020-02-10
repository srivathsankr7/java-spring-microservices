package com.event.eventmanagement.service;

import java.util.List;



import com.event.eventmanagement.model.Event;


public interface EventService {
	
	public List<Event> getEvents();
	
	public Event getEvent(int eventId);
	
	public void addEvent(Event event);
	
	public void updateEvent(int eventId, Event event);
	
	public void deleteEvent(int eventId);

}
