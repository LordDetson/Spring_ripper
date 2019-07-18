package by.babanin.puzzler3.actor;

import by.babanin.puzzler3.genre.AnyGenre;
import org.springframework.stereotype.Component;

@Component @AnyGenre
public class Chuck implements Actor {
    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}
