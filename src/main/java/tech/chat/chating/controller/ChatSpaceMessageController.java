package tech.chat.chating.controller;

import java.util.List;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tech.chat.chating.dto.ChatSpaceMessage;
import tech.chat.chating.service.ChatSpaceMessageService;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ChatSpaceMessageController {

  ChatSpaceMessageService chatSpaceMessageService;

  @GetMapping("/chat/messages/")
  public ResponseEntity<List<ChatSpaceMessage>> getChatSpace(@RequestParam String spaceId,
                                                            @RequestParam String username) {
    var userMessages = chatSpaceMessageService.findAllUserMessages(username, spaceId);
    return ResponseEntity.ok(userMessages);
  }

}
