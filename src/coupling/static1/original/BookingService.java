package coupling.static1.original;

import java.util.Date;

import coupling.common.BookingException;
import coupling.common.BookingResult;

class BookingService {

  public BookingResult bookConference(String topic) {
    ConferencingServer server = new ConferencingServer();
    MeetingCalendar calendar = MeetingCalendar.getInstance();
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
