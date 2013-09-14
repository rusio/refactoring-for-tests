package coupling.static2.original;

import coupling.common.BookingResult;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public final class BookingServiceTest {

  @Test
  public void testConferenceBooking_HappyPath() throws Exception {

    // collaborator containing other collaborators
    BigFatContext bigFatContext = new BigFatContext();

    // object under test
    BookingService bookingService = new BookingService(bigFatContext);

    // book a conference
    BookingResult result = bookingService.bookConference("Big Trouble in Little China");

    // check the state of the result
    assertTrue(result.isSuccess());
  }

  // NOTE: real collaborators will open network connections,
  // query databases and interact with other real collaborators..

  // => not a unit test, this is an integration test (!)

  // NOTE: no isolation of the object under test
}
