package coupling.static1.refactored;

import java.util.Date;

class MeetingCalendarImpl implements MeetingCalendar {

  // NOTE: no more Singleton

  @Override
  public Date nextPossibleDate() {
    // NOTE: the real implementation would look up some
    // meetingCalendar database and calculate the date
    return new Date();
  }
}
