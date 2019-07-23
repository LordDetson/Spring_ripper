package by.babanin.example1;

import by.babanin.example1.infra.Action;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Husband {
    @Autowired
    private Wife wife;

    private String money;

    @Action
    public void action() {
        System.out.println("Муж: " + wife.getCaress().toUpperCase() + " важнее, чем " + money);
    }

    @PostConstruct
    public void init() {
        money = "500$";
    }

    public void doSomething() {
        System.out.println("Муж: я пожалуй на рыбалку...");
    }

    public String getMoney() {
        return money;
    }
}
