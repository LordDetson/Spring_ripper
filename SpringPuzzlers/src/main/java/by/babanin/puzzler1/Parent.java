package by.babanin.puzzler1;

import javax.annotation.PostConstruct;

public class Parent {
    @PostConstruct
    private void init() {
        System.out.println("Папа");
    }
}
