package coupling1;

import java.util.Date;

import chance.Chances;
import coupling.BookingException;

class ConferencingServerImpl implements ConferencingServer {

  @Override
  public void bookConference(String topic, Date startDate) throws BookingException {
    if (Chances.isHappyPath()) {
      System.out.println("TOPIC: " + topic + " START: " + startDate);
    }
    else {
      throw new BookingException("Failed to book conference: " + topic);
    }
  }
}
