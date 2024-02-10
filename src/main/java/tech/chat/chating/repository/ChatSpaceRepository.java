package tech.chat.chating.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import tech.chat.chating.dto.ChatSpace;

public interface ChatSpaceRepository extends MongoRepository<ChatSpace, String> {

  List<ChatSpace> findAllByConnectedUsersUsername(String username);

  Optional<ChatSpace> findBySpaceId(String spaceId);

  Optional<ChatSpace> findByName(String name);
}
