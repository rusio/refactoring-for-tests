package coupling.dynamic.original;

import coupling.common.NotificationException;

class InstantMessenger {

  public void sendMessage(String recepientUri, String messageText) throws NotificationException {
    // NOTE: imagine this sends an instant message via SIP
    if (Math.random() > 0.2) {
      System.out.println("TO: " + recepientUri + " BODY: " + messageText);
    }
    else {
      throw new NotificationException("Failed to notify: " + recepientUri);
    }
  }

}
