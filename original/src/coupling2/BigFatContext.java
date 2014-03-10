package coupling2;

import java.util.HashMap;
import java.util.Map;

/**
 * NOTE: imagine it is difficult to instantiate this
 * class and its collaborators in a test harness.
 */
final class BigFatContext extends FrameworkClass {

  private final Map<String, Object> services = new HashMap<String, Object>();

  public BigFatContext() {
    // NOTE: the map contains real objects, which are created here
    // => how to replace these two with mock objects in a test?
    services.put("server", new ConferencingServerImpl());
    services.put("calendar", new MeetingCalendarImpl());
  }

  public ConferencingServer getConferencingServer() {
    return (ConferencingServer) services.get("server");
  }

  public MeetingCalendar getMeetingCalendar() {
    return (MeetingCalendar) services.get("calendar");
  }
}
