package coupling.static2.refactored1;

import coupling.common.FrameworkClass;
import coupling.static2.common.ConferencingServer;
import coupling.static2.common.ConferencingServerImpl;
import coupling.static2.common.MeetingCalendar;
import coupling.static2.common.MeetingCalendarImpl;

import java.util.HashMap;
import java.util.Map;

public class BigFatContextImpl extends FrameworkClass implements BigFatContext {

  private final Map<String, Object> services = new HashMap<String, Object>();

  public BigFatContextImpl() {
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
