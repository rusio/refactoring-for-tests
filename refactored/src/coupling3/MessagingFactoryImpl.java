package coupling3;

public class MessagingFactoryImpl implements MessagingFactory {

  @Override
  public MessageBuilder createMessageBuilder() {
    return new MessageBuilderImpl();
  }

  @Override
  public MessageSender createMessageSender(String recepientUri) {
    if (recepientUri.startsWith("sip:")) {
      return new InstantMessenger();
    }
    if (recepientUri.startsWith("mailto:")) {
      return new EmailSender();
    }
    throw new IllegalArgumentException("URI scheme not supported: "
                                       + recepientUri);
  }
}
