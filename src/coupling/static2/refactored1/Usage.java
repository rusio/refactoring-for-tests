package coupling.static2.refactored1;

class Usage {

  public static void main(String[] args) throws Exception {
    BigFatContext bigFatContext = new BigFatContextImpl();
    BookingService bookingService = new BookingService(bigFatContext);
    bookingService.bookConference("Big Trouble in Little China");
  }
}
