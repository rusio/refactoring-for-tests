package coupling.static2.refactored1;

import coupling.common.FrameworkClass;
import coupling.static2.common.ConferencingServer;
import coupling.static2.common.ConferencingServerImpl;
import coupling.static2.common.MeetingCalendar;
import coupling.static2.common.MeetingCalendarImpl;

import java.util.HashMap;
import java.util.Map;

/**
 * NOTE: extracted interface
 */
public class BigFatContextImpl extends FrameworkClass implements BigFatContext {

  private final Map<String, Object> services = new HashMap<String, Object>();

  public BigFatContextImpl() {
    // NOTE: the map contains real objects, which are created here
    // => how to replace these two with mock objects in a test?
    services.put("conferencingServer", new ConferencingServerImpl());
    services.put("meetingCalendar", new MeetingCalendarImpl());
  }

  @Override
  public ConferencingServer getConferencingServer() {
    return (ConferencingServer) services.get("conferencingServer");
  }

  @Override
  public MeetingCalendar getMeetingCalendar() {
    return (MeetingCalendar) services.get("meetingCalendar");
  }
}
