package coupling.common;

import java.util.Date;

public final class BookingResult {

  private final BookingException error;
  private final Date startDate;

  private BookingResult(BookingException error, Date startDate) {
    this.error = error;
    this.startDate = startDate;
  }

  public static BookingResult forSuccess(Date startDate) {
    return new BookingResult(null, startDate);
  }

  public static BookingResult forFailure(BookingException error) {
    return new BookingResult(error, null);
  }

  public boolean isSuccess() {
    return error == null;
  }

  public Date getStartDate() {
    return startDate;
  }

  public BookingException getError() {
    return error;
  }
}
