package coupling.static2.original;

class Usage {

  public static void main(String[] args) throws Exception {
    BigFatContext bigFatContext = new BigFatContext();
    BookingService bookingService = new BookingService(bigFatContext);
    bookingService.bookConference("Big Trouble in Little China");
  }
}
