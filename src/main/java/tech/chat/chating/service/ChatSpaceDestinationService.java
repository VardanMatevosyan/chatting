package tech.chat.chating.service;

import java.time.LocalDateTime;

public interface ChatSpaceDestinationService {

  String getPrivateDestination(String spaceId);

  String getPublicDestination(String spaceId);
}
