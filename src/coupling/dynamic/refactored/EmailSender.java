package coupling.dynamic.refactored;

import coupling.common.NotificationException;

public class EmailSender implements MessageSender {

  @Override
  public void notifyParticipant(String recepientUri, String messageText) throws NotificationException {
    // NOTE: imagine this sends an email message via SMTP
  }

}
