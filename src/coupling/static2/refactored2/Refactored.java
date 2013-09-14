package coupling.static2.refactored2;

import coupling.common.BookingException;

/**
 * NOTE: now using direct collaborators of the BookingService
 * instead of BigFatContext, which is just a provider of the
 * real collaborators. Using direct collaborators simplifies
 * the test setup.
 */
public class Refactored {

  public void usage() throws BookingException {
    // NOTE: the real implementation would create
    // these objects at a central place.
    BigFatContext bigFatContext = new BigFatContext();
    BookingService bookingService = new BookingService(bigFatContext.getConferencingServer(),
                                                       bigFatContext.getMeetingCalendar());
    bookingService.bookConference("Big Trouble in Little China");
  }
}
