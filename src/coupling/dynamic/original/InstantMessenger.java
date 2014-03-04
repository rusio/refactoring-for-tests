package coupling.dynamic.original;

import common.Chances;
import coupling.common.NotificationException;

class InstantMessenger {

  public void sendMessage(String recepientUri, String messageText) throws NotificationException {
    if (Chances.isHappyPath()) {
      // NOTE: imagine this sends an instant message via SIP
      System.out.println("TO: " + recepientUri + " BODY: " + messageText);
    }
    else {
      throw new NotificationException("Failed to notify: " + recepientUri);
    }
  }

}
