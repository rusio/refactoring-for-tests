package coupling2.context;

import coupling2.ConferencingServer;
import coupling2.ConferencingServerImpl;
import coupling2.FrameworkClass;
import coupling2.MeetingCalendar;
import coupling2.MeetingCalendarImpl;

import java.util.HashMap;
import java.util.Map;

class BigFatContextImpl extends FrameworkClass implements BigFatContext {

  private final Map<String, Object> services = new HashMap<String, Object>();

  public BigFatContextImpl() {
    services.put("server", new ConferencingServerImpl());
    services.put("calendar", new MeetingCalendarImpl());
  }

  @Override
  public ConferencingServer getConferencingServer() {
    return (ConferencingServer) services.get("server");
  }

  @Override
  public MeetingCalendar getMeetingCalendar() {
    return (MeetingCalendar) services.get("calendar");
  }
}
