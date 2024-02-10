package tech.chat.chating.dto;

import java.time.LocalDateTime;
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
@Document(collection = "chat_space_message")
public class ChatSpaceMessage {
  @Id
  String id;
  String spaceId;
  String messageOwnerUserName;
  String fromUsername;
  String toUsername;
  String message;
  LocalDateTime created = LocalDateTime.now();
}
