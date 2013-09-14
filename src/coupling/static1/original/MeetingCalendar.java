package coupling.static1.original;

import java.util.Date;

class MeetingCalendar {

  private static final MeetingCalendar instance = new MeetingCalendar();

  private MeetingCalendar() {
    // enforce Singleton
  }

  public static MeetingCalendar getInstance() {
    return instance;
  }

  public Date nextPossibleDate() {
    // NOTE: real implementation would look up some
    // calendar database and calculate the date
    return new Date();
  }
}
