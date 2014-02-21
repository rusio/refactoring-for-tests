package coupling.static2.refactored1;

public class Usage {

  public static void main(String[] args) throws Exception {
    // NOTE: the real implementation would create
    // these objects at a central place.
    BigFatContext bigFatContext = new BigFatContextImpl();
    BookingService bookingService = new BookingService(bigFatContext);
    bookingService.bookConference("Big Trouble in Little China");
  }
}
