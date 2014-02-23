package coupling.dynamic.original;

import coupling.common.NotificationException;

class EmailSender {

  public void sendEmail(String recepientUri, String messageText) throws NotificationException {
    // NOTE: imagine this sends an email message via  SMTP
    System.out.println("TO: " + recepientUri + " BODY: " + messageText);
  }

}
