package coupling.static1.original;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import coupling.common.BookingResult;

public class BookingServiceTest {

  @Test
  public void testConferenceBooking_HappyPath() throws Exception {
    // arrange
    BookingService service = new BookingService();

    // act
    BookingResult result = service.bookConference("Test Conference");

    // assert
    assertTrue(result.isSuccess());
    assertNull(result.getError());
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
