package coupling.static1.refactored;

import coupling.common.BookingException;
import coupling.common.BookingResult;

import java.util.Date;

public class BookingService {

  private final ConferencingServer conferencingServer;
  private final MeetingCalendar meetingCalendar;

  public BookingService(ConferencingServer conferencingServer,
                        MeetingCalendar meetingCalendar) {
    this.conferencingServer = conferencingServer;
    this.meetingCalendar = meetingCalendar;
  }

  public BookingResult bookConference(String topic) throws BookingException {
    Date startDate = meetingCalendar.nextPossibleDate();
    try {
      return conferencingServer.bookConference(topic, startDate);
    }
    catch (BookingException e) {
      return BookingResult.forFailure(e);
    }
  }
}
