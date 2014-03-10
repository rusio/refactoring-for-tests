package coupling1;

import java.util.Date;

import chance.Chances;

class MeetingCalendar {

  private static final MeetingCalendar instance = new MeetingCalendar();

  private MeetingCalendar() {
    // enforce Singleton
  }

  public static MeetingCalendar getInstance() {
    return instance;
  }

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
