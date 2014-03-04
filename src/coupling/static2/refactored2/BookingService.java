package coupling.static2.refactored2;

import java.util.Date;

import coupling.common.BookingException;
import coupling.common.BookingResult;
import coupling.static2.common.ConferencingServer;
import coupling.static2.common.MeetingCalendar;

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
