package coupling.static2.original;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import coupling.common.BookingResult;

public final class BookingServiceTest {

  @Test
  public void testConferenceBooking_HappyPath() throws Exception {

    // collaborator as supplier for other collaborators
    BigFatContext context = new BigFatContext();

    // object under test
    BookingService service = new BookingService(context);

    // book a conference
    BookingResult result = service.bookConference("Tango & Cash");

    // check the state of the result
    assertTrue(result.isSuccess());
  }

  // NOTE: real collaborators will open network connections,
  // query databases and interact with other real collaborators..

  // => not a unit test, this is an integration test (!)

  // NOTE: no isolation of the object under test
}
