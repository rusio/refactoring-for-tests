package coupling.dynamic.refactored;

interface MessagingFactory {

  MessageBuilder createMessageBuilder();

  MessageSender createMessageSender(String recepientUri);

}
