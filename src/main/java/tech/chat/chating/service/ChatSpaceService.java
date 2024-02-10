package tech.chat.chating.service;

import java.util.List;
import java.util.Optional;
import tech.chat.chating.dto.ChatSpace;
import tech.chat.chating.dto.ChatSpaceMessage;
import tech.chat.chating.dto.UserSpaceDto;

public interface ChatSpaceService {

  void sendPrivateMessage(ChatSpaceMessage chatSpaceMessage, String principalUserName);
  void sendPublicMessage(ChatSpaceMessage chatSpaceMessage);
  ChatSpace save(ChatSpace chatSpace);
  ChatSpace findById(String spaceId);
  List<ChatSpace> findByUsername(String username);
  ChatSpace findByName(String name);

  ChatSpace connectUser(UserSpaceDto userSpaceDto);
}
