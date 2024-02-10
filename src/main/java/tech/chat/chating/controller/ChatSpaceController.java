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
import tech.chat.chating.dto.UserSpaceDto;
import tech.chat.chating.service.ChatSpaceService;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ChatSpaceController {

  ChatSpaceService chatSpaceService;

  @PostMapping("/chat/spaces")
  public ResponseEntity<ChatSpace> createChatSpace(@RequestBody ChatSpace chatSpace) {
    ChatSpace saved = chatSpaceService.save(chatSpace);
    return ResponseEntity.status(HttpStatus.CREATED).body(saved);
  }

  @GetMapping("/chat/spaces/{username}")
  public ResponseEntity<List<ChatSpace>> getUserChatSpaces(@PathVariable String username) {
    List<ChatSpace> userChatSpaces = chatSpaceService.findByUsername(username);
    return ResponseEntity.ok(userChatSpaces);
  }

  @GetMapping("/chat/spaces/{spaceId}")
  public ResponseEntity<ChatSpace> getChatSpace(@PathVariable String spaceId) {
    ChatSpace chatSpace = chatSpaceService.findById(spaceId);
    return ResponseEntity.ok(chatSpace);
  }

  @GetMapping("/chat/spaces/{name}")
  public ResponseEntity<ChatSpace> getChatSpaceByName(@PathVariable String name) {
    // need to use list and use like filtering
    ChatSpace chatSpace = chatSpaceService.findByName(name);
    return ResponseEntity.ok(chatSpace);
  }

  @PostMapping("/chat/users")
  public ResponseEntity<ChatSpace> createChatSpace(@RequestBody UserSpaceDto userSpaceDto) {
    ChatSpace saved = chatSpaceService.connectUser(userSpaceDto);
    return ResponseEntity.ok(saved);
  }

}
