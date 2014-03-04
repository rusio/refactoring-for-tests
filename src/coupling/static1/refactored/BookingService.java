package coupling.static1.refactored;

import java.util.Date;

import coupling.common.BookingException;
import coupling.common.BookingResult;

class BookingService {

  private final ConferencingServer server;
  private final MeetingCalendar calendar;

  public BookingService(ConferencingServer server, MeetingCalendar calendar) {
    this.server = server;
    this.calendar = calendar;
  }

  public BookingResult bookConference(String topic) {
    Date startDate = calendar.nextPossibleDate();
    try {
      server.bookConference(topic, startDate);
      return BookingResult.forSuccess(startDate);
    }
    catch (BookingException e) {
      return BookingResult.forFailure(e);
    }
  }
}
