package coupling.common;

public class NotificationException extends Exception {
  private static final long serialVersionUID = -6377213170431697989L;

  public NotificationException() {
  }

  public NotificationException(String message) {
    super(message);
  }

  public NotificationException(String message, Throwable cause) {
    super(message, cause);
  }

  public NotificationException(Throwable cause) {
    super(cause);
  }
}
