package coupling.dynamic.original;

import coupling.common.NotificationResult;
import org.junit.Test;

import java.util.Date;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertTrue;

public class NotificationServiceTest {

  @Test
  public void testParticipantNotification_HappyPath() throws Exception {
    NotificationService notificationService = new NotificationService();
    List<String> participantUris = asList("sip:Jack.Burton@highway.com");
    NotificationResult result = notificationService.notifyParticipants(participantUris,
                                                                       new Date());
    assertTrue(result.isSuccess());
  }

  // QUESTION: can you see the problem with this test?

  // CHALLENGE: how would you assert here,
  // if notifyParticipants() was void?

  // CHALLENGE: how would you write a test,
  // that checks error conditions?
}
