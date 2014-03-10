package coupling3;

import static java.util.Arrays.asList;

import java.util.List;

import coupling.BookingResult;

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
