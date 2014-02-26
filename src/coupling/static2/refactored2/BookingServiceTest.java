package coupling.static2.refactored2;

import static junit.framework.Assert.assertTrue;
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

  // object under test
  private final BookingService bookingService = new BookingService(conferencingServer,
                                                                   meetingCalendar);

  @Test
  public void testConferenceBooking_HappyPath() throws Exception {
    // arrange
    Date startDate = new Date();
    when(meetingCalendar.nextPossibleDate()).thenReturn(startDate);

    // act
    BookingResult result = bookingService.bookConference("Test Conference");

    // assert
    assertTrue(result.isSuccess());
    verify(conferencingServer).bookConference("Test Conference", startDate);
  }

}
