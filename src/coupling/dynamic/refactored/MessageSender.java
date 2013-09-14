package coupling.dynamic.refactored;

import coupling.common.NotificationException;

public interface MessageSender {

  void notifyParticipant(String recepientUri, String messageText) throws NotificationException;

}
