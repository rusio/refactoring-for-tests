package coupling1;

import coupling.BookingException;
import coupling.BookingResult;

import java.util.Date;

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
