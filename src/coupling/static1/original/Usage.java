package coupling.static1.original;

public class Usage {

  public static void main(String[] args) throws Exception {
    BookingService bookingService = new BookingService();
    bookingService.bookConference("Big Trouble in Little China");
  }
}
