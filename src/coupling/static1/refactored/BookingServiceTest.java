package coupling.static1.refactored;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Date;

import org.junit.Test;

import coupling.common.BookingException;
import coupling.common.BookingResult;

public class BookingServiceTest {

  // mocked collaborators
  private final ConferencingServer conferencingServer = mock(ConferencingServer.class);
  private final MeetingCalendar meetingCalendar = mock(MeetingCalendar.class);

  // object under test
  private final BookingService bookingService = new BookingService(conferencingServer,
                                                     meetingCalendar);

  @Test
  public void testConferenceBooking_HappyPath() throws Exception {
    // setup the behaviour of the collaborators
    Date startDate = new Date();
    when(meetingCalendar.nextPossibleDate()).thenReturn(startDate);

    // book a conference
    BookingResult actualResult = bookingService.bookConference("Test Conference");

    // verify the interactions with the collaborators
    verify(conferencingServer).bookConference("Test Conference", startDate);

    // QUESTION: what type of testing do we see here?

    // QUESTION: Why don't we assert on the state of the BookingResult in this test?
  }

  @Test
  public void testConferenceBooking_ServerFailure() throws Exception {
    // setup the behaviour of the collaborators
    doThrow(new BookingException()).when(conferencingServer).bookConference(anyString(), (Date) any());

    // book a conference
    BookingResult result = bookingService.bookConference("Test Conference");

    // verify the state of the BookingResult
    assertFalse(result.isSuccess());
    assertNotNull(result.getErrorCause());
    assertNull(result.getStartDate());

    // QUESTION: Why do we assert on the state of the BookingResult in this test?
  }
}
