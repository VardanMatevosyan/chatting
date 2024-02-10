package tech.chat.chating.service.impl;

import java.util.List;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.chat.chating.dto.ChatSpace;
import tech.chat.chating.dto.ChatSpaceMessage;
import tech.chat.chating.repository.ChatSpaceMessageRepository;
import tech.chat.chating.repository.ChatSpaceRepository;
import tech.chat.chating.service.ChatSpaceMessageService;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ChatSpaceMessageServiceImpl implements ChatSpaceMessageService {

  final ChatSpaceMessageRepository chatSpaceMessageRepository;
  final ChatSpaceRepository chatSpaceRepository;

  @Override
  public void save(ChatSpaceMessage chatSpaceMessage) {
    chatSpaceMessageRepository.save(chatSpaceMessage);
  }

  @Override
  @Transactional
  public void savePrivateMessageToUsers(ChatSpaceMessage chatSpaceMessage) {
    // need to implement clone if mongo repo will determine the entity as not new
    // to save two objects
    saveChatSpaceMessage(chatSpaceMessage, chatSpaceMessage.getFromUsername());
    saveChatSpaceMessage(chatSpaceMessage, chatSpaceMessage.getToUsername());
  }

  @Override
  @Transactional
  public void savePublicMessageToUsers(ChatSpaceMessage chatSpaceMessage) {
    ChatSpace chatSpace = chatSpaceRepository.findById(chatSpaceMessage.getSpaceId()).orElseThrow();
    chatSpace
        .getConnectedUsers()
        .forEach(user -> saveChatSpaceMessage(chatSpaceMessage, user.getUsername()));
  }

  private void saveChatSpaceMessage(ChatSpaceMessage chatSpaceMessage, String chatSpaceUser) {
    // need to implement clone if mongo repo will determine the entity as not new
    // to save two objects
    chatSpaceMessage.setMessageOwnerUserName(chatSpaceUser);
    chatSpaceMessageRepository.save(chatSpaceMessage);
  }

  @Override
  public List<ChatSpaceMessage> findAllUserMessages(String username, String spaceId) {
    return chatSpaceMessageRepository
        .findChatSpaceMessageByMessageOwnerUserNameAndSpaceId(username, spaceId);
  }

}
