package tech.chat.chating.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;
import tech.chat.chating.config.filter.CustomHeaderHandshakeInterceptor;

@Configuration
public class WebSocketBrokerConfig implements WebSocketMessageBrokerConfigurer {

  @Value("${chat.relay.host}")
  private String relayHost;

  @Value("${chat.relay.port}")
  private Integer relayPort;

  @Override
  public void registerStompEndpoints(StompEndpointRegistry registry) {
    registry
        .addEndpoint("/socket/chat")
        .setAllowedOriginPatterns("*")
        .addInterceptors(new HttpSessionHandshakeInterceptor(), new CustomHeaderHandshakeInterceptor())
        .withSockJS();
  }

  public void configureMessageBroker(MessageBrokerRegistry registry) {
    registry
        .enableStompBrokerRelay("/topic", "/queue")
        .setUserDestinationBroadcast("/topic/unresolved.user.dest")
        .setUserRegistryBroadcast("/topic/registry.broadcast")
        .setRelayHost(relayHost)
        .setRelayPort(relayPort);

    registry.setApplicationDestinationPrefixes("/app");
  }

}
