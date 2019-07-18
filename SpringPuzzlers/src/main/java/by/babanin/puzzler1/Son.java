package by.babanin.puzzler1;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Son extends Parent {
    /*
    Вызовиться метод init У Parent и Son, так как спринг рекурсивно проходиться по всем наследникам до Object
    и вызывает все методы, помеченые аннотацией @PostConstruct
     */
    @PostConstruct
    public void init() {
        System.out.println("Cын");
    }
}
