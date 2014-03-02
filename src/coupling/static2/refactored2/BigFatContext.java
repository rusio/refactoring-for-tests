package coupling.static2.refactored2;

import coupling.common.FrameworkClass;
import coupling.static2.common.ConferencingServer;
import coupling.static2.common.ConferencingServerImpl;
import coupling.static2.common.MeetingCalendar;
import coupling.static2.common.MeetingCalendarImpl;

import java.util.HashMap;
import java.util.Map;

class BigFatContext extends FrameworkClass {

  private final Map<String, Object> services = new HashMap<String, Object>();

  public BigFatContext() {
    services.put("conferencingServer", new ConferencingServerImpl());
    services.put("meetingCalendar", new MeetingCalendarImpl());
  }

  public ConferencingServer getConferencingServer() {
    return (ConferencingServer) services.get("conferencingServer");
  }

  public MeetingCalendar getMeetingCalendar() {
    return (MeetingCalendar) services.get("meetingCalendar");
  }
}
