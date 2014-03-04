package coupling.dynamic.original;

import common.Chances;
import coupling.common.NotificationException;

class EmailSender {

  public void sendEmail(String recepientUri, String messageText) throws NotificationException {
    if (Chances.isHappyPath()) {
      // NOTE: imagine this sends an email message via SMTP
      System.out.println("TO: " + recepientUri + " BODY: " + messageText);
    }
    else {
      throw new NotificationException("Failed to notify: " + recepientUri);
    }
  }

}
