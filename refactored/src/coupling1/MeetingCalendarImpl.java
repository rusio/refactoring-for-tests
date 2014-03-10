package coupling1;

import java.util.Date;

class MeetingCalendarImpl implements MeetingCalendar {

  @Override
  public Date nextPossibleDate() {
    return new Date();
  }
}
