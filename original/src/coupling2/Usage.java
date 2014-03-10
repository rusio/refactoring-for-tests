package coupling2;

class Usage {

  public static void main(String[] args) throws Exception {
    BigFatContext context = new BigFatContext();
    BookingService service = new BookingService(context);
    service.bookConference("Big Trouble in Little China");
  }
}
