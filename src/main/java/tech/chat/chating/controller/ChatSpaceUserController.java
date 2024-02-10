package tech.chat.chating.controller;

import java.util.List;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tech.chat.chating.dto.ChatSpace;
import tech.chat.chating.service.ChatSpaceService;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ChatSpaceUserController {

  ChatSpaceService chatSpaceService;

  @PostMapping("users/{username}/chat/spaces/{spaceId}")
  public ResponseEntity<ChatSpace> createChatSpace(@RequestBody ChatSpace chatSpace) {
    ChatSpace saved = chatSpaceService.save(chatSpace);
    return ResponseEntity.status(HttpStatus.CREATED).body(saved);
  }

}
