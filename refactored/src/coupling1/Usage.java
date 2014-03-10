package coupling1;

class Usage {

  public static void main(String[] args) throws Exception {
    ConferencingServer server = new ConferencingServerImpl();
    MeetingCalendar calendar = new MeetingCalendarImpl();
    BookingService service = new BookingService(server, calendar);
    service.bookConference("Big Trouble in Little China");
  }
}
