package by.babanin.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.StringJoiner;

@Entity
public class Talk {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long talkId;
    private LocalDateTime dateTime;
    private String title;

    public Talk() {
    }

    public Talk(LocalDateTime dateTime, String title) {
        this.dateTime = dateTime;
        this.title = title;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Talk.class.getSimpleName() + "[", "]")
                .add("title='" + title + "'")
                .toString();
    }
}
