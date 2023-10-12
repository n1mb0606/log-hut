package pingpong.loghut.data;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.CrossOrigin;
import pingpong.loghut.Message;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

@CrossOrigin("*")
public interface MessageRepository extends CrudRepository<Message, Long> {
    Message findMessageById(Long id);

    List<Message> findAllByOrderByUpVoteDesc();

    List<Message> findAllByOrderByDownVoteDesc();

    List<Message> findAllByOrderByCreatedAtAsc();

    List<Message> findAllByOrderByCreatedAtDesc();

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("UPDATE Message SET upVote = upVote + 1 where id = ?1")
    void incrementUpVoteById(Long id);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("UPDATE Message SET downVote = downVote + 1 where id = ?1")
    void incrementDownVoteById(Long id);
}
