package tech.chat.chating;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisIndexedHttpSession;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;

@SpringBootApplication
@EnableWebSocketMessageBroker
@EnableRedisIndexedHttpSession
public class ChatingApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChatingApplication.class, args);
	}

}
