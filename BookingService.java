import java.util.*;

public class BookingService {
    private List<Ticket> bookedTickets = new ArrayList<>();
    private Queue<Ticket> waitingList = new LinkedList<>();
    private final int MAX_SEATS = 5;

    public void bookTicket(String customer, String movie) {
        if (bookedTickets.size() < MAX_SEATS) {
            bookedTickets.add(new Ticket(customer, movie));
            System.out.println("Ticket booked successfully.");
        } else {
            waitingList.add(new Ticket(customer, movie));
            System.out.println("Seats full. Added to waiting list.");
        }
    }

    public void viewWaitingList() {
        if (waitingList.isEmpty()) {
            System.out.println("Waiting list is empty.");
            return;
        }

        System.out.println("Waiting List:");
        for (Ticket t : waitingList) {
            System.out.println(t);
        }
    }

    public void processNextBooking() {
        if (waitingList.isEmpty()) {
            System.out.println("No one in waiting list.");
            return;
        }

        if (bookedTickets.size() < MAX_SEATS) {
            Ticket t = waitingList.poll();
            bookedTickets.add(t);
            System.out.println("Seat allotted to: " + t);
        } else {
            System.out.println("No seats available currently.");
        }
    }

    public void cancelBooking(String name) {
        Iterator<Ticket> it = bookedTickets.iterator();
        boolean found = false;

        while (it.hasNext()) {
            Ticket t = it.next();
            if (t.getCustomerName().equalsIgnoreCase(name)) {
                it.remove();
                found = true;
                System.out.println("Booking cancelled.");
                break;
            }
        }

        if (!found) {
            System.out.println("Booking not found.");
        }
    }

    public void viewBookedTickets() {
        if (bookedTickets.isEmpty()) {
            System.out.println("No booked tickets.");
            return;
        }

        System.out.println("Booked Tickets:");
        for (Ticket t : bookedTickets) {
            System.out.println(t);
        }
    }

    public void movieSummary() {
        if (bookedTickets.isEmpty()) {
            System.out.println("No bookings yet.");
            return;
        }

        Map<String, Integer> map = new HashMap<>();

        for (Ticket t : bookedTickets) {
            map.put(t.getMovieName(), map.getOrDefault(t.getMovieName(), 0) + 1);
        }

        System.out.println("Movie-wise Booking Summary:");
        for (String movie : map.keySet()) {
            System.out.println(movie + " -> " + map.get(movie) + " tickets");
        }
    }
}