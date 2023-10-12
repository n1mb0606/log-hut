package pingpong.loghut;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pingpong.loghut.data.MessageRepository;

import java.util.Date;

@SpringBootApplication
public class LogHutApplication {

    public static void main(String[] args) {
        SpringApplication.run(LogHutApplication.class, args);
    }

    @Bean
    public CommandLineRunner dataLoader(MessageRepository messageRepository) {
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
            }
        };
    }
}
