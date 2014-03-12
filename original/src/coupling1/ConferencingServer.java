package coupling1;

import coupling.BookingException;
import simulation.Chances;
import simulation.RemoteCalls;

import java.util.Date;

class ConferencingServer {

  public void bookConference(String topic, Date startDate) throws BookingException {
    if (Chances.isHappyPath()) {
      // NOTE: imagine this connects to the conferencing server and books the conference
      RemoteCalls.perform();
      System.out.println("TOPIC: " + topic + " START: " + startDate);
    }
    else {
      throw new BookingException("Failed to book conference: " + topic);
    }
  }
}
