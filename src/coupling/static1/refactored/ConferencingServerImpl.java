package coupling.static1.refactored;

import coupling.common.BookingException;
import coupling.common.BookingResult;

import java.util.Date;

class ConferencingServerImpl implements ConferencingServer {

  @Override
  public BookingResult bookConference(String topic, Date startDate) throws BookingException {
    // NOTE: the real implementation would connect to
    // the conferencing conferencingServer and book the conference
    System.out.println("TOPIC: " + topic + " START: " + startDate);

    return BookingResult.forSuccess("0721/480848-000", startDate);
  }
}
