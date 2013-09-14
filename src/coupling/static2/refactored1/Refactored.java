package coupling.static2.refactored1;

import coupling.common.BookingException;

public class Refactored {

  public void usage() throws BookingException {
    // NOTE: the real implementation would create
    // these objects at a central place.
    BigFatContext bigFatContext = new BigFatContextImpl();
    BookingService bookingService = new BookingService(bigFatContext);
    bookingService.bookConference("Big Trouble in Little China");
  }
}
