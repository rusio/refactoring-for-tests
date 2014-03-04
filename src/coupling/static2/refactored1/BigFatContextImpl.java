package coupling.static2.refactored1;

import java.util.HashMap;
import java.util.Map;

import coupling.static2.common.ConferencingServer;
import coupling.static2.common.ConferencingServerImpl;
import coupling.static2.common.FrameworkClass;
import coupling.static2.common.MeetingCalendar;
import coupling.static2.common.MeetingCalendarImpl;

public class BigFatContextImpl extends FrameworkClass implements BigFatContext {

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
