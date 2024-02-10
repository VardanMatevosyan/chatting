package tech.chat.chating.config.filter;

import java.util.Collections;
import java.util.Map;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;


// TODO remove this after finishing the frontend port
public class CustomHeaderHandshakeInterceptor implements HandshakeInterceptor {

  @Override
  public boolean beforeHandshake(
      ServerHttpRequest request,
      ServerHttpResponse response,
      WebSocketHandler wsHandler,
      Map<String, Object> attributes) throws Exception {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    if (authentication != null && authentication.isAuthenticated()) {
      String username = authentication.getName();
      response.getHeaders().put("username", Collections.singletonList(username));
      attributes.put("username", username);
    }
    System.out.println("before handshake");
    response.getHeaders().forEach((key, value) -> System.out.println("Header key " + key + " value " + value));
    attributes.forEach((key, value) -> System.out.println("Attr key " + key + " value " + value));

    return true;
  }

  @Override
  public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response,
      WebSocketHandler wsHandler, Exception exception) {
    // No action needed after handshake
  }

}