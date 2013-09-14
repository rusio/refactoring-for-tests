package coupling.static1.original;

import coupling.common.BookingException;
import coupling.common.BookingResult;

import java.util.Date;

class ConferencingServer {

  public BookingResult bookConference(String topic, Date startDate) throws BookingException {
    // NOTE: real implementation would connect to
    // the conferencing server and book the conference
    return BookingResult.forSuccess("0721/480848-000", startDate);
  }
}
