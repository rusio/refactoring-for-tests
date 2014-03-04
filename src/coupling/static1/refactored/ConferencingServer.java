package coupling.static1.refactored;

import java.util.Date;

import coupling.common.BookingException;

interface ConferencingServer {

  void bookConference(String topic, Date startDate) throws BookingException;

}
