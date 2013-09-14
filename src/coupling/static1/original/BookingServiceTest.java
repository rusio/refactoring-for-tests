package coupling.static1.original;

import coupling.common.BookingResult;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class BookingServiceTest {

  @Test
  public void testConferenceBooking_HappyPath() throws Exception {
    // object under test
    BookingService bookingService = new BookingService();

    // book a conference
    BookingResult result = bookingService.bookConference("Test Conference");

    // verify the state of the BookingResult
    assertTrue(result.isSuccess());
    assertNull(result.getErrorCause());
    assertNotNull(result.getPhoneNumber());
    assertNotNull(result.getStartDate());

    // QUESTION: Can you see the problem with this test?
  }

  @Test
  public void testConferenceBooking_ServerFailure() throws Exception {
    // CHALLENGE: Write a test that checks the error handling
    // in case of an error (BookingException) while interacting
    // with the conferencing server.
  }
}
