package coupling3;

import coupling.NotificationException;

interface MessageSender {

  void notifyParticipant(String messageText) throws NotificationException;

}
