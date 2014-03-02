package coupling.static1.refactored;

class Usage {

  public static void main(String[] args) throws Exception {
    ConferencingServer conferencingServer = new ConferencingServerImpl();
    MeetingCalendar meetingCalendar = new MeetingCalendarImpl();
    BookingService bookingService = new BookingService(conferencingServer,
                                                       meetingCalendar);
    bookingService.bookConference("Big Trouble in Little China");
  }
}
