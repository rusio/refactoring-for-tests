package coupling1;

import coupling.BookingException;
import simulation.Chances;
import simulation.RemoteCalls;

import java.util.Date;

class ConferencingServerImpl implements ConferencingServer {

  @Override
  public void bookConference(String topic, Date startDate) throws BookingException {
    if (Chances.isHappyPath()) {
      RemoteCalls.perform();
      System.out.println("TOPIC: " + topic + " START: " + startDate);
    }
    else {
      throw new BookingException("Failed to book conference: " + topic);
    }
  }
}
