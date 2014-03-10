package coupling3;

import java.util.Date;
import java.util.List;

import coupling.NotificationException;
import coupling.NotificationResult;

class NotificationService {

  private final MessagingFactory messagingFactory;

  public NotificationService(MessagingFactory messagingFactory) {
    this.messagingFactory = messagingFactory;
  }

  public NotificationResult notifyParticipants(List<String> participantUris,
                                               Date startDate) {
    String notificationMessage = buildNotificationMessage(startDate);
    return sendMessage(participantUris, notificationMessage);
  }

  private NotificationResult sendMessage(List<String> participantUris,
                                         String notificationMessage) {
    NotificationResult result = new NotificationResult();
    for (String participantUri : participantUris) {
      try {
        notifyParticipant(participantUri, notificationMessage);
      }
      catch (NotificationException e) {
        result.addError(e);
      }
    }
    return result;
  }

  private String buildNotificationMessage(Date startDate) {
    MessageBuilder messageBuilder = messagingFactory.createMessageBuilder();
    return messageBuilder.buildNotificationMessage(startDate);
  }

  private void notifyParticipant(String participantUri,
                                 String notificationMessage) throws NotificationException {
    MessageSender messageSender = messagingFactory.createMessageSender(participantUri);
    messageSender.notifyParticipant(participantUri, notificationMessage);
  }

}
