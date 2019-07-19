package by.babanin.puzzler3;

import by.babanin.puzzler3.actor.Actor;
import by.babanin.puzzler3.genre.Action;
import by.babanin.puzzler3.genre.Comedy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

/*
Аннотации @Qualifier совмещаються со знаком & - все условия должны совпадать.
Если хоть один не совпадает, то не инжектица.


 */
@Component
public class Film {
    @Autowired
    @Comedy
    @Action
    public List<Actor> actors;

    @PostConstruct
    public void printActors() {
        actors.forEach(System.out::println);
    }
}
