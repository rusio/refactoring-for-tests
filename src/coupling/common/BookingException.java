package coupling.common;

public class BookingException extends Exception {
  private static final long serialVersionUID = -3837096128263913838L;

  public BookingException() {
  }

  public BookingException(String message) {
    super(message);
  }

  public BookingException(String message, Throwable cause) {
    super(message, cause);
  }

  public BookingException(Throwable cause) {
    super(cause);
  }
}
