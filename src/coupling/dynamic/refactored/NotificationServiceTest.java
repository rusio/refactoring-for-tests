package coupling.dynamic.refactored;

import coupling.common.NotificationException;
import coupling.common.NotificationResult;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertFalse;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class NotificationServiceTest {

  // fixed test params
  private static final Date START_DATE = new Date();
  private static final String MESSAGE = "Test Message";
  private static final String[] PARTICIPANTS = { "sip:p0@xyz.de", "sip:p1@xyz.de" };

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

    verify(messageSender).notifyParticipant(PARTICIPANTS[0], MESSAGE);
    verify(messageSender).notifyParticipant(PARTICIPANTS[1], MESSAGE);
  }

  @Test
  public void testParticipantNotification_SenderFailure() throws Exception {
    doThrow(new NotificationException()).when(messageSender)
                                        .notifyParticipant(anyString(),
                                                           anyString());

    NotificationResult result = notificationService.notifyParticipants(asList(PARTICIPANTS),
                                                                       START_DATE);

    assertFalse(result.isSuccess());
  }

}
