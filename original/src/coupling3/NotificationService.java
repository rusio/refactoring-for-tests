package coupling3;

import coupling.NotificationException;
import coupling.NotificationResult;

import java.util.Date;
import java.util.List;

class NotificationService {

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
        result.addError(e);
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
      InstantMessenger instantMessenger = new InstantMessenger(participantUri);
      instantMessenger.sendMessage(notificationMessage);
    }
    else if (participantUri.startsWith("mailto:")) {
      EmailSender emailSender = new EmailSender(participantUri);
      emailSender.sendEmail(notificationMessage);
    }
  }

}
