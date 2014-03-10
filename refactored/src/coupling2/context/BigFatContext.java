package coupling2.context;

import coupling2.ConferencingServer;
import coupling2.MeetingCalendar;

interface BigFatContext {

  ConferencingServer getConferencingServer();

  MeetingCalendar getMeetingCalendar();

}
