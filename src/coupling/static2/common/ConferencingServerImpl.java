package coupling.static2.common;

import coupling.common.BookingException;
import coupling.common.BookingResult;

import java.util.Date;

public class ConferencingServerImpl implements ConferencingServer {

  @Override
  public BookingResult bookConference(String topic, Date startDate) throws BookingException {
    // NOTE: the real implementation would connect to
    // the conferencing server and book the conference
    return BookingResult.forSuccess("0721/480848-000", startDate);
  }
}
