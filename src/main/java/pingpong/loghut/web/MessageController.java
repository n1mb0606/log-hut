package pingpong.loghut.web;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;
import pingpong.loghut.Message;
import pingpong.loghut.data.MessageRepository;

@RestController
@RequestMapping("/messages")
@CrossOrigin("*")
public class MessageController {
    MessageRepository messageRepository;

    MessageController(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @GetMapping("/{id}/upvote")
    public void incrementUpVote(@PathVariable("id") Long id) {
        messageRepository.incrementUpVoteById(id);
    }

    @GetMapping("/{id}/downvote")
    public void decrementUpVote(@PathVariable("id") Long id) {
        messageRepository.incrementDownVoteById(id);
    }
}