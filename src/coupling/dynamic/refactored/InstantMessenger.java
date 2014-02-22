package coupling.dynamic.refactored;

import coupling.common.NotificationException;

public class InstantMessenger implements MessageSender {

  @Override
  public void notifyParticipant(String recepientUri, String messageText) throws NotificationException {
    // NOTE: imagine this sends an instant message via SIP
    System.out.println("TO: " + recepientUri + " BODY: " + messageText);
  }

}
