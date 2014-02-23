package coupling.dynamic.original;

import coupling.common.BookingResult;
import coupling.dynamic.common.BookingService;
import coupling.dynamic.common.ConferencingServer;
import coupling.dynamic.common.ConferencingServerImpl;
import coupling.dynamic.common.MeetingCalendar;
import coupling.dynamic.common.MeetingCalendarImpl;

import java.util.List;

import static java.util.Arrays.asList;

class Usage {

  public static void main(String[] args) throws Exception {
    // sample setup
    ConferencingServer conferencingServer = new ConferencingServerImpl();
    MeetingCalendar meetingCalendar = new MeetingCalendarImpl();
    BookingService bookingService = new BookingService(conferencingServer,
                                                       meetingCalendar);
    NotificationService notificationService = new NotificationService();

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
