package coupling.dynamic.refactored;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.stubbing.Stubber;

import coupling.common.NotificationException;
import coupling.common.NotificationResult;

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
  private final NotificationService notificationService = new NotificationService(messagingFactory);

  @Before
  public void setUp() {
    when(messagingFactory.createMessageBuilder()).thenReturn(messageBuilder);
    when(messagingFactory.createMessageSender(PARTICIPANTS[0])).thenReturn(messageSender);
    when(messagingFactory.createMessageSender(PARTICIPANTS[1])).thenReturn(messageSender);
  }

  @Test
  public void testParticipantNotification_HappyPath() throws Exception {
    when(messageBuilder.buildNotificationMessage(START_DATE)).thenReturn(MESSAGE);

    NotificationResult result = notificationService.notifyParticipants(asList(PARTICIPANTS),
                                                                       START_DATE);

    assertTrue(result.isSuccess());
    verify(messageSender).notifyParticipant(PARTICIPANTS[0], MESSAGE);
    verify(messageSender).notifyParticipant(PARTICIPANTS[1], MESSAGE);
  }

  @Test
  public void testParticipantNotification_SenderFailure() throws Exception {
    arrangeNotificationException(PARTICIPANTS[0]);
    arrangeNotificationException(PARTICIPANTS[1]);

    NotificationResult result = notificationService.notifyParticipants(asList(PARTICIPANTS),
                                                                       START_DATE);

    assertFalse(result.isSuccess());
    List<NotificationException> errors = result.getErrors();
    assertEquals(2, errors.size());
    assertEquals(PARTICIPANTS[0], errors.get(0).getMessage());
    assertEquals(PARTICIPANTS[1], errors.get(1).getMessage());
  }

  private void arrangeNotificationException(String message) throws NotificationException {
    Stubber stubber = doThrow(new NotificationException(message));
    stubber.when(messageSender).notifyParticipant(eq(message), anyString());
  }

}
