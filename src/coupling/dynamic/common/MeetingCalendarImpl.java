package coupling.dynamic.common;

import java.util.Date;

import common.Chances;

public class MeetingCalendarImpl implements MeetingCalendar {

  // NOTE: no more Singleton

  @Override
  public Date nextPossibleDate() {
    if (Chances.isHappyPath()) {
      // NOTE: imagine this uses a calendar database to calculate the date
      return new Date();
    }
    else {
      // NOTE: simulate that no date is available for the meeting
      return null;
    }
  }
}
