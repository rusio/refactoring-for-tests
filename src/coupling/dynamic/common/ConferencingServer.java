package coupling.dynamic.common;

import java.util.Date;

import coupling.common.BookingException;
import coupling.common.BookingResult;

public interface ConferencingServer {

  BookingResult bookConference(String topic, Date startDate) throws BookingException;

}
