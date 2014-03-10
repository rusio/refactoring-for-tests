package coupling3;

interface MessagingFactory {

  MessageBuilder createMessageBuilder();

  MessageSender createMessageSender(String recepientUri);

}
