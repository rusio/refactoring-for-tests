package coupling2.direct;

/**
 * NOTE: now using direct collaborators of the BookingService
 * instead of BigFatContext, which is just a supplier of the
 * real collaborators. Using direct collaborators simplifies
 * the test setup.
 */
class Usage {

  public static void main(String[] args) throws Exception {
    BigFatContext context = new BigFatContext();
    BookingService service = new BookingService(context.getConferencingServer(),
                                                context.getMeetingCalendar());
    service.bookConference("Big Trouble in Little China");
  }
}
