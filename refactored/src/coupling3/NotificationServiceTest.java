package coupling3;

import coupling.NotificationException;
import coupling.NotificationResult;
import org.junit.Before;
import org.junit.Test;
import org.mockito.stubbing.Stubber;

import java.util.Date;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class NotificationServiceTest {

  // fixed test params
  private static final Date START_DATE = new Date();
  private static final String MESSAGE = "Test Message";
  private static final String[] PARTICIPANTS = { "sip:p0@xyz.de",
                                                "sip:p1@xyz.de" };

  // mocked collaborators
  private final MessageBuilder messageBuilder = mock(MessageBuilder.class);
  private final MessageSender messageSender = mock(MessageSender.class);
  private final MessagingFactory messagingFactory = mock(MessagingFactory.class);

  // object under test
  private final NotificationService service = new NotificationService(messagingFactory);

  @Before
  public void setUp() {
    when(messagingFactory.createMessageBuilder()).thenReturn(messageBuilder);
    when(messagingFactory.createMessageSender(PARTICIPANTS[0])).thenReturn(messageSender);
    when(messagingFactory.createMessageSender(PARTICIPANTS[1])).thenReturn(messageSender);
  }

  @Test
  public void testParticipantNotification_HappyPath() throws Exception {
    when(messageBuilder.buildNotificationMessage(START_DATE)).thenReturn(MESSAGE);

    NotificationResult result = service.notifyParticipants(asList(PARTICIPANTS),
                                                           START_DATE);

    assertTrue(result.isSuccess());
    verify(messageSender, times(2)).notifyParticipant(MESSAGE);
  }

  @Test
  public void testParticipantNotification_SenderFailure() throws Exception {
    when(messageBuilder.buildNotificationMessage(START_DATE)).thenReturn(MESSAGE);
    arrangeSenderFailure();

    NotificationResult result = service.notifyParticipants(asList(PARTICIPANTS),
                                                           START_DATE);

    assertFalse(result.isSuccess());
    List<NotificationException> errors = result.getErrors();
    assertEquals(2, errors.size());
    assertEquals(PARTICIPANTS[0], errors.get(0).getMessage());
    assertEquals(PARTICIPANTS[1], errors.get(1).getMessage());
  }

  private void arrangeSenderFailure() throws NotificationException {
    Stubber stubber = doThrow(new NotificationException(PARTICIPANTS[0]));
    stubber = stubber.doThrow(new NotificationException(PARTICIPANTS[1]));
    stubber.when(messageSender).notifyParticipant(MESSAGE);
  }
}
