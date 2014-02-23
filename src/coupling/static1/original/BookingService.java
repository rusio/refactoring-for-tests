package coupling.static1.original;

import coupling.common.BookingException;
import coupling.common.BookingResult;

import java.util.Date;

class BookingService {

  public BookingResult bookConference(String topic) {
    ConferencingServer conferencingServer = new ConferencingServer();
    MeetingCalendar meetingCalendar = MeetingCalendar.getInstance();
    Date startDate = meetingCalendar.nextPossibleDate();
    try {
      return conferencingServer.bookConference(topic, startDate);
    }
    catch (BookingException e) {
      return BookingResult.forFailure(e);
    }
  }
}
