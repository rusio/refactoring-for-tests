package coupling.static1.refactored;

import coupling.common.BookingException;

import java.util.Date;

interface ConferencingServer {

  void bookConference(String topic, Date startDate) throws BookingException;

}
