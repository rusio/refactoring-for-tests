package coupling.common;

import java.util.HashMap;
import java.util.Map;

public final class NotificationResult {

  private Map<String, NotificationException> errors = new HashMap<String, NotificationException>();

  public void addError(String participantUri, NotificationException e) {
    errors.put(participantUri, e);
  }

  public boolean isSuccess() {
    return errors.isEmpty();
  }
}
