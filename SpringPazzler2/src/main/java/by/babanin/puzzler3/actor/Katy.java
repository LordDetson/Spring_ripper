package by.babanin.puzzler3.actor;

import org.springframework.stereotype.Component;

@Component
public class Katy implements Actor {
    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}
