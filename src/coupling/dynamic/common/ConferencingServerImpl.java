package coupling.dynamic.common;

import java.util.Date;

import coupling.common.BookingException;

public class ConferencingServerImpl implements ConferencingServer {

  @Override
  public void bookConference(String topic, Date startDate) throws BookingException {
    // NOTE: the real implementation would connect to
    // the conferencing conferencingServer and book the conference
    if (Math.random() > 0.2) {
      System.out.println("TOPIC: " + topic + " START: " + startDate);
    }
    else {
      throw new BookingException("Failed to book conference: " + topic);
    }
  }
}
