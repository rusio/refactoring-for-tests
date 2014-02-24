package coupling.static2.refactored1;

import coupling.common.BookingException;
import coupling.common.BookingResult;
import coupling.static2.common.ConferencingServer;
import coupling.static2.common.MeetingCalendar;

import java.util.Date;

class BookingService {

  private final BigFatContext bigFatContext;

  public BookingService(BigFatContext bigFatContext) {
    this.bigFatContext = bigFatContext;
  }

  public BookingResult bookConference(String topic) {
    MeetingCalendar meetingCalendar = bigFatContext.getMeetingCalendar();
    Date startDate = meetingCalendar.nextPossibleDate();
    try {
      ConferencingServer conferencingServer = bigFatContext.getConferencingServer();
      conferencingServer.bookConference(topic, startDate);
      return BookingResult.forSuccess("0721/480848-000", startDate);
    }
    catch (BookingException e) {
      return BookingResult.forFailure(e);
    }
  }
}
