package coupling.dynamic.original;

import coupling.common.NotificationException;

class EmailSender {

  public void sendEmail(String recepientUri, String messageText) throws NotificationException {
    // NOTE: imagine this sends an email message via  SMTP
    if (Math.random() > 0.2) {
      System.out.println("TO: " + recepientUri + " BODY: " + messageText);
    }
    else {
      throw new NotificationException("Failed to notify: " + recepientUri);
    }
  }

}
