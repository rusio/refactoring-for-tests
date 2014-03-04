package coupling.static2.refactored2;

import java.util.HashMap;
import java.util.Map;

import coupling.static2.common.ConferencingServer;
import coupling.static2.common.ConferencingServerImpl;
import coupling.static2.common.FrameworkClass;
import coupling.static2.common.MeetingCalendar;
import coupling.static2.common.MeetingCalendarImpl;

class BigFatContext extends FrameworkClass {

  private final Map<String, Object> services = new HashMap<String, Object>();

  public BigFatContext() {
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
