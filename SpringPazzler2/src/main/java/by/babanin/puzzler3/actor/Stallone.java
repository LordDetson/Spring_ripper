package by.babanin.puzzler3.actor;

import by.babanin.puzzler3.genre.Action;
import by.babanin.puzzler3.genre.Comedy;
import org.springframework.stereotype.Component;

@Component @Comedy @Action
public class Stallone implements Actor {
    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}
