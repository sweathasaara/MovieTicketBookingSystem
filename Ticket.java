public class Ticket {
    private String customerName;
    private String movieName;

    public Ticket(String customerName, String movieName) {
        this.customerName = customerName;
        this.movieName = movieName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getMovieName() {
        return movieName;
    }

    @Override
    public String toString() {
        return "Customer: " + customerName + ", Movie: " + movieName;
    }
}