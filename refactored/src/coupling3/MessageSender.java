package coupling3;

import coupling.NotificationException;

public interface MessageSender {

  void notifyParticipant(String recepientUri, String messageText) throws NotificationException;

}
