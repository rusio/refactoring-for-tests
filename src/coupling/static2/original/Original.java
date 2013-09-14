package coupling.static2.original;

import coupling.common.BookingException;

public class Original {

  public void usage() throws BookingException {
    // NOTE: the real implementation would create
    // these objects at a central place.
    BigFatContext bigFatContext = new BigFatContext();
    BookingService bookingService = new BookingService(bigFatContext);
    bookingService.bookConference("Big Trouble in Little China");
  }
}
