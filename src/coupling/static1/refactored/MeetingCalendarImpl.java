package coupling.static1.refactored;

import java.util.Date;

class MeetingCalendarImpl implements MeetingCalendar {

  @Override
  public Date nextPossibleDate() {
    return new Date();
  }
}
