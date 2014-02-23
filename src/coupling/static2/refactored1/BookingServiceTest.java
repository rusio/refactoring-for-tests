package coupling.static2.refactored1;

import coupling.common.BookingResult;
import coupling.static2.common.ConferencingServer;
import coupling.static2.common.MeetingCalendar;
import org.junit.Test;

import java.util.Date;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public final class BookingServiceTest {

  // mocked collaborators
  private final ConferencingServer conferencingServer = mock(ConferencingServer.class);
  private final MeetingCalendar meetingCalendar = mock(MeetingCalendar.class);

  // NOTE: now mocking an interface
  private final BigFatContext bigFatContext = mock(BigFatContextImpl.class);

  // object under test
  private final BookingService bookingService = new BookingService(bigFatContext);

  @Test
  public void testConferenceBooking_HappyPath() throws Exception {
    // setup the bigFatContext
    when(bigFatContext.getConferencingServer()).thenReturn(conferencingServer);
    when(bigFatContext.getMeetingCalendar()).thenReturn(meetingCalendar);

    // setup the collaborators
    Date startDate = new Date();
    when(meetingCalendar.nextPossibleDate()).thenReturn(startDate);

    // book a conference
    BookingResult result = bookingService.bookConference("Test Conference");

    // verify the interactions with the collaborators
    verify(conferencingServer).bookConference("Test Conference", startDate);
  }

}
