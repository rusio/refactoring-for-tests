package coupling.static1.refactored;

import coupling.common.BookingException;
import coupling.common.BookingResult;

import java.util.Date;

interface ConferencingServer {

  BookingResult bookConference(String topic, Date startDate) throws BookingException;

}
