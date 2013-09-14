package coupling.dynamic.refactored;

public interface MessagingFactory {

  MessageBuilder createMessageBuilder();

  MessageSender createMessageSender(String recepientUri);

}
