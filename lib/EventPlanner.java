package event.lib;

import java.util.*;
import java.time.*;

public class EventPlanner {

	private String name;
	private ArrayList<Event> events = new ArrayList<>();
	private ArrayList<Event> requestedEvents = new ArrayList<>();

	public EventPlanner(String name) {
		this.name = name;
	}

	public Event findEvent(String id) throws Exception {
		for (Event e : events) {
			if (e.getEventId().equals(id)) {
				return e;
			}
		}
		throw new Exception("Event ID not found");

	}

	public Event findRequestedEvent(String id) throws Exception {
		for (Event e : requestedEvents) {
			if (e.getEventId().equals(id)) {
				return e;
			}
		}
		throw new Exception("Requested event not found");
	}

	public ArrayList<Event> searchEvents(String title) {
		ArrayList<Event> result = new ArrayList<>();
		for (Event e : events) {
			if (e.getEventTitle().contains(title)) {
				result.add(e);
			}
		}
		return result;
	}

	public ArrayList<TourPackage> searchForTourPackages(String title) {
		ArrayList<TourPackage> result = new ArrayList<>();
		for (Event e : events) {
			if (e instanceof TourPackage && e.getEventTitle().contains(title)) {
				result.add((TourPackage) e);
			}
		}
		return result;
	}

	public String requestEvent(String eventTitle, String customerContact, LocalDate eventDate, int durationInDays,
			int numOfParticipants) {
		CorporateEvent corporateEvent = new CorporateEvent(eventTitle, customerContact, eventDate, durationInDays,
				numOfParticipants);
		requestedEvents.add(corporateEvent);
		return corporateEvent.getEventId();
	}

	public void acceptEvent(String eventID) throws Exception {
		Event event = findRequestedEvent(eventID);
		if (event != null) {
			requestedEvents.remove(event);
			events.add(event);
		}
	}

	public String offerTourPackage(String eventTitle, LocalDate eventDate, int durationInDays, int numOfParticipants,
			int perPersonPrice, ArrayList<String> placesToVisit) {
		TourPackage tourPackage = new TourPackage(eventTitle, eventDate, durationInDays, numOfParticipants,
				perPersonPrice);
		for (String place : placesToVisit) {
			tourPackage.addPlacesToVisit(place);
		}
		events.add(tourPackage);
		return tourPackage.getEventId();
	}

	public String offerTourPackage(String eventTitle, LocalDate eventDate, int durationInDays, int numOfParticipants,
			int perPersonPrice) {
		TourPackage tourPackage = new TourPackage(eventTitle, eventDate, durationInDays, numOfParticipants,
				perPersonPrice);
		events.add(tourPackage);
		return tourPackage.getEventId();
	}

	public void registerForTour(String tourId, int participants, String contact) throws Exception {
		Event event = findEvent(tourId);
		if (event instanceof TourPackage) {
			((TourPackage) event).registerForTour(participants, contact);
		}
	}

	public void assignEventManager(String eventID, String managerName) throws Exception {
		Event e = findEvent(eventID);
		if (e != null) {
			e.setEventManager(managerName);
		}
	}

	public void addEventTask(String eventID, String title, String description) throws Exception {
		Event e = findEvent(eventID);
		if (e != null) {
			e.addTask(title, description);
		}
	}

	public void startEventTask(String eventID, String title) throws Exception {
		Event e = findEvent(eventID);
		if (e != null) {
			e.startTask(title);
		}
	}

	public void completeEventTask(String eventID, String title) throws Exception {
		Event e = findEvent(eventID);
		if (e != null) {
			e.completeTask(title);
		}
	}

	public double payBill(String eventId) throws Exception {
		Event e = findEvent(eventId);
		if (e != null) {
			return e.getBill();
		} else {
			return -1;
		}
	}

	public String getName() {
		return name;
	}

	public void acceptedEvent() {
		for (Event e : events) {
			System.out.println(e);
		}
	}

	public void showEvents() {
		System.out.println(events);
	}
	
}