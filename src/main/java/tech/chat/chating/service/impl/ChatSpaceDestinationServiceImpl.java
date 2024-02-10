package tech.chat.chating.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tech.chat.chating.service.ChatSpaceDestinationService;

@Service
@RequiredArgsConstructor
public class ChatSpaceDestinationServiceImpl implements ChatSpaceDestinationService {

  @Override
  public String getPrivateDestination(String spaceId) {
    return "/queue/" + spaceId + ".private.messages";
  }

  @Override
  public String getPublicDestination(String spaceId) {
    return "/topic/" + spaceId + ".public.messages";
  }

}
