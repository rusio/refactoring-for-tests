package coupling.common;

import java.util.Date;

public final class BookingResult {

  private final BookingException errorCause;
  private final Date startDate;

  private BookingResult(BookingException errorCause,
                        Date startDate) {
    this.errorCause = errorCause;
    this.startDate = startDate;
  }

  public static BookingResult forSuccess(Date startDate) {
    return new BookingResult(null, startDate);
  }

  public static BookingResult forFailure(BookingException error) {
    return new BookingResult(error, null);
  }

  public boolean isSuccess() {
    return errorCause == null;
  }

  public Date getStartDate() {
    return startDate;
  }

  public BookingException getErrorCause() {
    return errorCause;
  }
}
