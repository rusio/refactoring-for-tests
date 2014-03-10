package coupling1;

import java.util.Date;

import coupling.BookingException;

interface ConferencingServer {

  void bookConference(String topic, Date startDate) throws BookingException;

}
