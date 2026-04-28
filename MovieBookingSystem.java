import java.util.Scanner;

public class MovieBookingSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MovieService movieService = new MovieService();
        BookingService bookingService = new BookingService();

        while (true) {
            System.out.println("\n1. Add New Movie");
            System.out.println("2. View All Movies");
            System.out.println("3. Book Ticket");
            System.out.println("4. View Booking Queue");
            System.out.println("5. Process Next Booking");
            System.out.println("6. Cancel Booking");
            System.out.println("7. View Booked Tickets");
            System.out.println("8. Movie-wise Summary");
            System.out.println("9. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter movie name: ");
                    movieService.addMovie(sc.nextLine());
                    break;

                case 2:
                    movieService.viewMovies();
                    break;

                case 3:
                    System.out.print("Enter customer name: ");
                    String customer = sc.nextLine();

                    System.out.print("Enter movie name: ");
                    String movie = sc.nextLine();

                    if (!movieService.movieExists(movie)) {
                        System.out.println("Movie not found.");
                    } else {
                        bookingService.bookTicket(customer, movie);
                    }
                    break;

                case 4:
                    bookingService.viewWaitingList();
                    break;

                case 5:
                    bookingService.processNextBooking();
                    break;

                case 6:
                    System.out.print("Enter customer name: ");
                    bookingService.cancelBooking(sc.nextLine());
                    break;

                case 7:
                    bookingService.viewBookedTickets();
                    break;

                case 8:
                    bookingService.movieSummary();
                    break;

                case 9:
                    System.exit(0);

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}