package coupling.static1.original;

import java.util.Date;

import coupling.common.BookingException;

class ConferencingServer {

  public void bookConference(String topic, Date startDate) throws BookingException {
    // NOTE: rhe real implementation would connect to
    // the conferencing server and book the conference
    if (Math.random() > 0.2) {
      System.out.println("TOPIC: " + topic + " START: " + startDate);
    }
    else {
      throw new BookingException("Failed to book conference: " + topic);
    }
  }
}
