package coupling3;

class MessagingFactoryImpl implements MessagingFactory {

  @Override
  public MessageBuilder createMessageBuilder() {
    return new MessageBuilderImpl();
  }

  @Override
  public MessageSender createMessageSender(String recepientUri) {
    if (recepientUri.startsWith("sip:")) {
      return new InstantMessenger(recepientUri);
    }
    if (recepientUri.startsWith("mailto:")) {
      return new EmailSender(recepientUri);
    }
    throw new IllegalArgumentException("URI scheme not supported: "
                                       + recepientUri);
  }
}
