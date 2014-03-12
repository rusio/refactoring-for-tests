package coupling3;

import simulation.Chances;
import simulation.RemoteCalls;

import java.util.Date;

public class MeetingCalendarImpl implements MeetingCalendar {

  // NOTE: no more Singleton

  @Override
  public Date nextPossibleDate() {
    if (Chances.isHappyPath()) {
      // NOTE: imagine this uses a calendar database to calculate the date
      RemoteCalls.perform();
      return new Date();
    }
    else {
      // NOTE: simulate that no date is available for the meeting
      return null;
    }
  }
}
