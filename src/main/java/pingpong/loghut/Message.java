package pingpong.loghut;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Date;

@Data
@Entity
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date createdAt;

    @NotNull
    private String content;

    @Min(0)
    private int upVote;
    @Min(0)
    private int downVote;

    @PrePersist
    void createdAt() {
        this.createdAt = new Date();
    }
}
