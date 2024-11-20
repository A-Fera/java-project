package event.app;

import event.lib.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class EventPlannerApp {
	public static void main(String[] args) {
		EventPlanner evp1 = new EventPlanner("EVP1");
		while (true) {
			System.out.println("1 to login as employee\n2 as customer\n3 to switch role\n0 to exit");
			System.out.println("Role:");
			int role;
			try {
				role = new Scanner(System.in).nextInt();
				if (role == 1) {
					while (true) {
						System.out.println("Log in as employee");
						System.out.println("1 to offer tour package event\n2 to view accepted event\n"
								+ "3 to view requested event\n" + "4 to accept event\n" + "5 to assign event manager\n"
								+ "6 to add task\n" + "7 to start task\n" + "8 to complete task\n"
								+ "9 for all events\n" + "0 to logout\nOption:");
						int op = new Scanner(System.in).nextInt();
						if (op == 0) {
							System.out.println("Log out successfully.");
							break;
						} else if (op == 1) {
							evp1.showEvents();
							System.out.println("Eventtitle:");
							String eventTitle = new Scanner(System.in).next();
							System.out.println("Customer Contact:");
							String customerContact = new Scanner(System.in).next();
							System.out.println("Day no (1-31):");
							String date = new Scanner(System.in).next();
							System.out.println("Month no(1-12):");
							String month = new Scanner(System.in).next();
							System.out.println("Enter year:");
							String year = new Scanner(System.in).next();
							System.out.println("Duration days:");
							int durationInDays = new Scanner(System.in).nextInt();
							System.out.println("Number of participants:");
							int numOfParticipants = new Scanner(System.in).nextInt();
							System.out.println("Per person price:");
							int perPersonPrice = new Scanner(System.in).nextInt();
							if (date.length() == 1)
								date = "0" + date;
							if (month.length() == 1)
								month = "0" + month;
							if (year.length() != 4) {
								System.out.println("Please enter correct date:");
								continue;
							}
							LocalDate eventDate = LocalDate.parse(date + "/" + month + "/" + year,
									DateTimeFormatter.ofPattern("dd/MM/yyyy"));
							evp1.offerTourPackage(eventTitle, eventDate, durationInDays, numOfParticipants,
									perPersonPrice);

						} else if (op == 2) {
							evp1.showEvents();
							evp1.acceptedEvent();

						} else if (op == 3) {
							evp1.showEvents();
							// evp1.shoWrequestedEvents();

						} else if (op == 4) {
							evp1.showEvents();
							System.out.println("Event id:");
							String eventId = new Scanner(System.in).next();
							evp1.acceptEvent(eventId);
						} else if (op == 5) {
							evp1.showEvents();
							System.out.println("Event id:");
							String eventId = new Scanner(System.in).next();
							System.out.println("Event manager:");
							String managerName = new Scanner(System.in).next();
							;
							evp1.assignEventManager(eventId, managerName);
						} else if (op == 6) {
							evp1.showEvents();
							System.out.println("Event id:");
							String eventId = new Scanner(System.in).next();
							System.out.println("Task title:");
							String title = new Scanner(System.in).next();
							System.out.println("Task description:");
							String description = new Scanner(System.in).next();
							evp1.addEventTask(eventId, title, description);
						} else if (op == 7) {
							evp1.showEvents();
							System.out.println("Event id:");
							String eventId = new Scanner(System.in).next();
							System.out.println("Task title:");
							String title = new Scanner(System.in).next();
							evp1.startEventTask(eventId, title);
						} else if (op == 8) {
							evp1.showEvents();
							System.out.println("Event id:");
							String eventId = new Scanner(System.in).next();
							System.out.println("Task title:");
							String title = new Scanner(System.in).next();
							evp1.completeEventTask(eventId, title);
						} else if (op == 9) {
							evp1.showEvents();
						}
					}

				}

				else if (role == 2) {
					while (true) {
						System.out.println("1 to request for corporate event\n2 to search for tour packages\n" + //
								"3 to register for tour package\n4 to view the detail of their event\n5 to pay bill\n"
								+ "6 for all events\n" + "0 to logout\nOption:");
						int op = new Scanner(System.in).nextInt();
						if (op == 0) {
							break;
						} else if (op == 1) {
							evp1.showEvents();
							System.out.println("eventTitle:");
							String eventTitle = new Scanner(System.in).next();
							System.out.println("customerContact:");
							String customerContact = new Scanner(System.in).next();
							System.out.println("durationInDays:");
							int durationInDays = new Scanner(System.in).nextInt();
							System.out.println("numOfParticipants:");
							int numOfParticipants = new Scanner(System.in).nextInt();
							System.out.println("Day no (1-31):");
							String date = new Scanner(System.in).next();
							System.out.println("Month no(1-12):");
							String month = new Scanner(System.in).next();
							System.out.println("Enter year:");
							String year = new Scanner(System.in).next();
							if (date.length() == 1)
								date = "0" + date;
							if (month.length() == 1)
								month = "0" + month;
							if (year.length() != 4) {
								System.out.println("Please enter correct date:");
								continue;
							}
							LocalDate eventDate = LocalDate.parse(date + "/" + month + "/" + year,
									DateTimeFormatter.ofPattern("dd/MM/yyyy"));
							evp1.requestEvent(eventTitle, customerContact, eventDate, durationInDays,
									numOfParticipants);
						} else if (op == 2) {
							evp1.showEvents();
							System.out.println("Event title:");
							String title = new Scanner(System.in).next();
							System.out.println(evp1.searchForTourPackages(title));
						} else if (op == 3) {
							evp1.showEvents();
							System.out.println("TourId:");
							String tourId = new Scanner(System.in).next();
							System.out.println("Participants:");
							int participants = new Scanner(System.in).nextInt();
							System.out.println("Contact:");
							String contact = new Scanner(System.in).next();
							evp1.registerForTour(tourId, participants, contact);
						} else if (op == 4) {
							evp1.showEvents();

						} else if (op == 5) {
							evp1.showEvents();
							System.out.println("Event id:");
							String eventId = new Scanner(System.in).next();
							evp1.payBill(eventId);
						} else if (op == 6) {
							evp1.showEvents();
						}
					}
				} else if (role == 0) {
					System.out.println("Exit done.");
					break;
				} else
					System.out.println("Invalid role.");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
