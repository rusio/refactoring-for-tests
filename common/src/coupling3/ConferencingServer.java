package coupling3;

import java.util.Date;

import coupling.BookingException;

public interface ConferencingServer {

  void bookConference(String topic, Date startDate) throws BookingException;

}
