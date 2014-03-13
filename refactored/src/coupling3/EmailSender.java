package coupling3;

import simulation.Chances;
import coupling.NotificationException;
import simulation.RemoteCalls;

class EmailSender implements MessageSender {

  private final String recepientUri;

  public EmailSender(String recepientUri) {
    this.recepientUri = recepientUri;
  }

  @Override
  public void notifyParticipant(String messageText) throws NotificationException {
    if (Chances.isHappyPath()) {
      // NOTE: imagine this sends an email message via  SMTP
      RemoteCalls.perform();
      System.out.println("TO: " + recepientUri + " BODY: " + messageText);
    }
    else {
      throw new NotificationException("Failed to notify: " + recepientUri);
    }
  }

}
