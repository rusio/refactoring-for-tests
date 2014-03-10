package coupling1;

import java.util.Date;

import coupling.BookingException;
import coupling.BookingResult;

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
