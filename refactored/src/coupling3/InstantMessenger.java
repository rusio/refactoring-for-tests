package coupling3;

import simulation.Chances;
import coupling.NotificationException;
import simulation.RemoteCalls;

public class InstantMessenger implements MessageSender {

  @Override
  public void notifyParticipant(String recepientUri, String messageText) throws NotificationException {
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
