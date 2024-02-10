package tech.chat.chating.dto;

import java.util.ArrayList;
import java.util.List;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@Document(collection = "chat_space")
public class ChatSpace {

  @Id
  String spaceId;
  String name;
  String description;
  List<ChatSpaceUser> connectedUsers = new ArrayList<>();

  public void addUser(ChatSpaceUser chatSpaceUser) {
    if (!connectedUsers.contains(chatSpaceUser)) {
      connectedUsers.add(chatSpaceUser);
    }
  }
}
