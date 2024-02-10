package tech.chat.chating.service;

import java.util.List;
import tech.chat.chating.dto.ChatSpaceMessage;

public interface ChatSpaceMessageService {

  void save(ChatSpaceMessage chatSpaceMessage);
  void savePrivateMessageToUsers(ChatSpaceMessage chatSpaceMessage);
  void savePublicMessageToUsers(ChatSpaceMessage chatSpaceMessage);
  List<ChatSpaceMessage> findAllUserMessages(String username, String spaceId);


}
