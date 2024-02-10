package tech.chat.chating.listener;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;
import tech.chat.chating.service.ChatSpaceService;

@Component
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class WebSocketConnectionListener {

  ChatSpaceService chatSpaceService;

  // for need to create subscriptionMapping on the back and subscribe on the frontend

  @EventListener
  public void handleConnectedClientSession(SessionConnectEvent sessionConnectEvent) {
    log.info("Client session connected event" + sessionConnectEvent.getUser());
    // this is for online connected users to the chat space
    // and to notify in the chat space if the user join the chat space
  }

  @EventListener
  public void handleConnectedClientSession(SessionDisconnectEvent sessionDisconnectEvent) {
    log.info("Client session disconnected event" + sessionDisconnectEvent.getUser());
    // this is the user was online before and after become offline
    // and to notify in the chat space if the user leave the chat space
  }

}
