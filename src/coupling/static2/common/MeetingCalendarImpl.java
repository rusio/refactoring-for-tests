package coupling.static2.common;

import java.util.Date;

public class MeetingCalendarImpl implements MeetingCalendar {

  // NOTE: no more Singleton

  @Override
  public Date nextPossibleDate() {
    // NOTE: the real implementation would look up some
    // calendar database and calculate the date
    return new Date();
  }
}
