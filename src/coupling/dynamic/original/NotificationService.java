package coupling.dynamic.original;

import coupling.common.NotificationException;
import coupling.common.NotificationResult;

import java.util.Date;
import java.util.List;

public class NotificationService {

  public NotificationResult notifyParticipants(List<String> participantUris,
                                               Date startDate) {
    // prepare the info text about the conference
    String notificationMessage = buildNotificationMessage(startDate);

    // notify the participants
    NotificationResult result = new NotificationResult();
    for (String participantUri : participantUris) {
      try {
        notifyParticipant(participantUri, notificationMessage);
      }
      catch (NotificationException e) {
        result.addError(participantUri, e);
      }
    }
    return result;
  }

  private String buildNotificationMessage(Date startDate) {
    String text = "Time for Kung-Fu! We will call you at %s.";
    return String.format(text, startDate);
  }

  private void notifyParticipant(String participantUri,
                                 String notificationMessage) throws NotificationException {
    if (participantUri.startsWith("sip:")) {
      InstantMessenger instantMessenger = new InstantMessenger();
      instantMessenger.sendMessage(participantUri, notificationMessage);
    }
    else if (participantUri.startsWith("mailto:")) {
      EmailSender emailSender = new EmailSender();
      emailSender.sendEmail(participantUri, notificationMessage);
    }
  }

}
