package coupling.dynamic.common;

import java.util.Date;

import coupling.common.BookingException;

public interface ConferencingServer {

  void bookConference(String topic, Date startDate) throws BookingException;

}
