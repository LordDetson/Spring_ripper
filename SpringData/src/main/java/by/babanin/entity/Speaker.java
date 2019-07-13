package by.babanin.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringJoiner;

@Entity
public class Speaker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long spricerId;
    private String name;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Talk> talks;

    public Speaker() {
    }

    public Speaker(String name) {
        this.name = name;
    }

    public void addTalk(Talk talk) {
        if (talks == null) talks = new HashSet<>();
        talks.add(talk);
    }

    public String getName() {
        return name;
    }

    public Set<Talk> getTalks() {
        return talks;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Speaker.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .toString();
    }
}
