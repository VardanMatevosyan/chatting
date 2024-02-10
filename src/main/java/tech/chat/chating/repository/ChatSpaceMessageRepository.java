package tech.chat.chating.repository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import tech.chat.chating.dto.ChatSpaceMessage;

public interface ChatSpaceMessageRepository extends MongoRepository<ChatSpaceMessage, String> {

  List<ChatSpaceMessage> findChatSpaceMessageByMessageOwnerUserNameAndSpaceId(String username,
                                                                              String spaceId);
}
