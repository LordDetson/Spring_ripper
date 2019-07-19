package by.babanin.puzzler3.actor;

import by.babanin.puzzler3.genre.Melodram;
import org.springframework.stereotype.Component;

@Component @Melodram
public class Julia implements Actor {
    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}
