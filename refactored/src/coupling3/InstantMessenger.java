package coupling3;

import simulation.Chances;
import coupling.NotificationException;
import simulation.RemoteCalls;

class InstantMessenger implements MessageSender {

  private final String recepientUri;

  public InstantMessenger(String recepientUri) {
    this.recepientUri = recepientUri;
  }

  @Override
  public void notifyParticipant(String messageText) throws NotificationException {
    if (Chances.isHappyPath()) {
      // NOTE: imagine this sends an instant message via SIP
      RemoteCalls.perform();
      System.out.println("TO: " + recepientUri + " BODY: " + messageText);
    }
    else {
      throw new NotificationException("Failed to notify: " + recepientUri);
    }
  }

}
