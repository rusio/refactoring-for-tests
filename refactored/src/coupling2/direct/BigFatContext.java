package coupling2.direct;

import java.util.HashMap;
import java.util.Map;

import coupling2.ConferencingServer;
import coupling2.ConferencingServerImpl;
import coupling2.FrameworkClass;
import coupling2.MeetingCalendar;
import coupling2.MeetingCalendarImpl;

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
