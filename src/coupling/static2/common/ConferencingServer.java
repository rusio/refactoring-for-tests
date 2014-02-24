package coupling.static2.common;

import coupling.common.BookingException;

import java.util.Date;

public interface ConferencingServer {

  void bookConference(String topic, Date startDate) throws BookingException;

}
