package coupling.static2.refactored1;

import coupling.static2.common.ConferencingServer;
import coupling.static2.common.MeetingCalendar;

public interface BigFatContext {

  ConferencingServer getConferencingServer();

  MeetingCalendar getMeetingCalendar();

}
