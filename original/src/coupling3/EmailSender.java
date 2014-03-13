package coupling3;

import simulation.Chances;
import coupling.NotificationException;
import simulation.RemoteCalls;

class EmailSender {

  private final String recepientUri;

  public EmailSender(String recepientUri) {
    this.recepientUri = recepientUri;
  }

  public void sendEmail(String messageText) throws NotificationException {
    if (Chances.isHappyPath()) {
      // NOTE: imagine this sends an email message via SMTP
      RemoteCalls.perform();
      System.out.println("TO: " + recepientUri + " BODY: " + messageText);
    }
    else {
      throw new NotificationException("Failed to notify: " + recepientUri);
    }
  }

}
