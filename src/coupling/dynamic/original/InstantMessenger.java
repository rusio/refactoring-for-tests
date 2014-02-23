package coupling.dynamic.original;

import coupling.common.NotificationException;

class InstantMessenger {

  public void sendMessage(String recepientUri, String messageText) throws NotificationException {
    // NOTE: imagine this sends an instant message via SIP
    System.out.println("TO: " + recepientUri + " BODY: " + messageText);
  }

}
