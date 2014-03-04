package coupling.dynamic.common;

import java.util.Date;

import coupling.common.BookingException;
import coupling.common.BookingResult;

public class BookingService {

  private final ConferencingServer conferencingServer;
  private final MeetingCalendar meetingCalendar;

  public BookingService(ConferencingServer conferencingServer,
                        MeetingCalendar meetingCalendar) {
    this.conferencingServer = conferencingServer;
    this.meetingCalendar = meetingCalendar;
  }

  public BookingResult bookConference(String topic) {
    Date startDate = meetingCalendar.nextPossibleDate();
    try {
      conferencingServer.bookConference(topic, startDate);
      return BookingResult.forSuccess(startDate);
    }
    catch (BookingException e) {
      return BookingResult.forFailure(e);
    }
  }
}
