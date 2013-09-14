package coupling.static2.common;

import coupling.common.BookingException;
import coupling.common.BookingResult;

import java.util.Date;

public interface ConferencingServer {

  BookingResult bookConference(String topic, Date startDate) throws BookingException;

}
