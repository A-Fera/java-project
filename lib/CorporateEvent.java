package event.lib;

import java.time.LocalDate;

public class CorporateEvent extends Event{
	private String venue;
	private boolean hasDiscount;

	public String getVenue() {
		return venue;
	}

	public void setVenue(String venue) {
		this.venue = venue;
	}

	public boolean hasDiscount() {
		return hasDiscount;
	}

	public void setDiscount(boolean hasDiscount) {
		this.hasDiscount = hasDiscount;
	}

	public CorporateEvent(String eventTitle, String customerContact, LocalDate eventDate, int durationInDays,
			int numOfParticipants) {
		super(eventTitle, customerContact, eventDate, durationInDays, numOfParticipants);
		addPrefixCodeToId("CC-");
	}

	@Override
	public double getBill() {
		double bill = getNumOfParticipants()*getUnitPrice();
		if (hasDiscount)
			return 0.9*bill;
		
		return bill;
	}

}