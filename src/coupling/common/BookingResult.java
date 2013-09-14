package coupling.common;

import java.util.Date;

public final class BookingResult {

  private final BookingException errorCause;
  private final String phoneNumber;
  private final Date startDate;

  private BookingResult(BookingException errorCause,
                        String phoneNumber,
                        Date startDate) {
    this.errorCause = errorCause;
    this.phoneNumber = phoneNumber;
    this.startDate = startDate;
  }

  public static BookingResult forSuccess(String phoneNumber, Date startDate) {
    return new BookingResult(null, phoneNumber, startDate);
  }

  public static BookingResult forFailure(BookingException error) {
    return new BookingResult(error, null, null);
  }

  public boolean isSuccess() {
    return errorCause == null;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public Date getStartDate() {
    return startDate;
  }

  public BookingException getErrorCause() {
    return errorCause;
  }
}
