package coupling.dynamic.refactored;

import common.Chances;
import coupling.common.NotificationException;

public class EmailSender implements MessageSender {

  @Override
  public void notifyParticipant(String recepientUri, String messageText) throws NotificationException {
    if (Chances.isHappyPath()) {
      // NOTE: imagine this sends an email message via  SMTP
      System.out.println("TO: " + recepientUri + " BODY: " + messageText);
    }
    else {
      throw new NotificationException("Failed to notify: " + recepientUri);
    }
  }

}
