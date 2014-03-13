package coupling3;

import java.util.Date;
import java.util.List;

import static java.util.Arrays.asList;

class Usage {

  public static void main(String[] args) throws Exception {
    MessagingFactory factory = new MessagingFactoryImpl();
    NotificationService service = new NotificationService(factory);
    List<String> participantUris = asList("sip:Jack.Burton@trucker.com",
                                          "mailto:Egg.Shen@magician.com");
    service.notifyParticipants(participantUris, new Date());
  }
}
