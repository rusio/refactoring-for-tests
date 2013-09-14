package coupling.dynamic.refactored;

import static java.util.Arrays.asList;

import java.util.List;

import coupling.common.BookingException;
import coupling.common.BookingResult;
import coupling.dynamic.common.BookingService;
import coupling.dynamic.common.ConferencingServer;
import coupling.dynamic.common.ConferencingServerImpl;
import coupling.dynamic.common.MeetingCalendar;
import coupling.dynamic.common.MeetingCalendarImpl;

public class Refactored {

  public void usage() throws BookingException {
    // sample setup
    ConferencingServer conferencingServer = new ConferencingServerImpl();
    MeetingCalendar meetingCalendar = new MeetingCalendarImpl();
    BookingService bookingService = new BookingService(conferencingServer,
                                                       meetingCalendar);
    MessagingFactory messagingFactory = new MessagingFactoryImpl();
    NotificationService notificationService = new NotificationService(messagingFactory);

    // sample usage
    BookingResult bookingResult = bookingService.bookConference("Big Trouble in Little China");
    if (bookingResult.isSuccess()) {
      List<String> participantUris = asList("sip:Jack.Burton@trucker.com",
                                            "mailto:Egg.Shen@magician.com");
      notificationService.notifyParticipants(participantUris,
                                             bookingResult.getStartDate());
    }
  }
}
