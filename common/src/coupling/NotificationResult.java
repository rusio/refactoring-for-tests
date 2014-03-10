package coupling;

import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.Lists;

public final class NotificationResult {

  private final List<NotificationException> errors = new ArrayList<NotificationException>();

  public void addError(NotificationException error) {
    errors.add(error);
  }

  public boolean isSuccess() {
    return errors.isEmpty();
  }

  public List<NotificationException> getErrors() {
    return Lists.newArrayList(errors);
  }
}
