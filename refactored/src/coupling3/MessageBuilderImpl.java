package coupling3;

import java.util.Date;

class MessageBuilderImpl implements MessageBuilder {

  @Override
  public String buildNotificationMessage(Date startDate) {
    String text = "Time for Kung-Fu! We will call you at %s.";
    return String.format(text, startDate);
  }

}
