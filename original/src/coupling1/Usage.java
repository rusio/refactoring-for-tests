package coupling1;

class Usage {

  public static void main(String[] args) throws Exception {
    BookingService service = new BookingService();
    service.bookConference("Big Trouble in Little China");
  }
}
