package tech.chat.chating.service.impl;

import java.util.List;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;
import tech.chat.chating.dto.ChatSpace;
import tech.chat.chating.dto.ChatSpaceMessage;
import tech.chat.chating.dto.UserSpaceDto;
import tech.chat.chating.repository.ChatSpaceRepository;
import tech.chat.chating.service.ChatSpaceDestinationService;
import tech.chat.chating.service.ChatSpaceService;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ChatSpaceServiceImpl implements ChatSpaceService {

  final SimpMessagingTemplate simpMessagingTemplate;
  final ChatSpaceDestinationService chatSpaceDestinationService;
  final ChatSpaceRepository chatSpaceRepository;

  @Override
  public void sendPrivateMessage(ChatSpaceMessage chatSpaceMessage, String principalUserName) {
    String destination =
        chatSpaceDestinationService.getPrivateDestination(chatSpaceMessage.getSpaceId());
    simpMessagingTemplate
        .convertAndSendToUser(chatSpaceMessage.getToUsername(), destination, chatSpaceMessage);
    simpMessagingTemplate.convertAndSendToUser(principalUserName, destination, chatSpaceMessage);
  }

  @Override
  public void sendPublicMessage(ChatSpaceMessage chatSpaceMessage) {
    String destination =
        chatSpaceDestinationService.getPublicDestination(chatSpaceMessage.getSpaceId());
    simpMessagingTemplate.convertAndSend(destination, chatSpaceMessage);
  }

  @Override
  public ChatSpace save(ChatSpace chatSpace) {
    return chatSpaceRepository.save(chatSpace);
  }

  @Override
  public ChatSpace findById(String spaceId) {
    return chatSpaceRepository.findBySpaceId(spaceId).orElseThrow();
  }

  @Override
  public List<ChatSpace> findByUsername(String username) {
    return chatSpaceRepository.findAllByConnectedUsersUsername(username);
  }

  @Override
  public ChatSpace findByName(String name) {
    return chatSpaceRepository.findByName(name).orElseThrow();
  }

  @Override
  public ChatSpace connectUser(UserSpaceDto userSpaceDto) {
    ChatSpace chatSpace = findById(userSpaceDto.getSpaceId());
    chatSpace.addUser(userSpaceDto.getChatSpaceUser());
    return chatSpaceRepository.save(chatSpace);
  }

}
