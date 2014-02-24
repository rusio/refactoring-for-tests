package coupling.dynamic.refactored;

import coupling.common.NotificationException;

public class EmailSender implements MessageSender {

  @Override
  public void notifyParticipant(String recepientUri, String messageText) throws NotificationException {
    // NOTE: imagine this sends an email message via  SMTP
    if (Math.random() > 0.2) {
      System.out.println("TO: " + recepientUri + " BODY: " + messageText);
    }
    else {
      throw new NotificationException("Failed to notify: " + recepientUri);
    }
  }

}
