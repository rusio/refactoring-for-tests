package coupling.static2.refactored1;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Date;

import org.junit.Test;

import coupling.common.BookingResult;
import coupling.static2.common.ConferencingServer;
import coupling.static2.common.MeetingCalendar;

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
    // arrange
    Date startDate = new Date();
    when(bigFatContext.getConferencingServer()).thenReturn(conferencingServer);
    when(bigFatContext.getMeetingCalendar()).thenReturn(meetingCalendar);
    when(meetingCalendar.nextPossibleDate()).thenReturn(startDate);

    // act
    BookingResult result = bookingService.bookConference("Test Conference");

    // assert
    assertTrue(result.isSuccess());
    verify(conferencingServer).bookConference("Test Conference", startDate);
  }

}
