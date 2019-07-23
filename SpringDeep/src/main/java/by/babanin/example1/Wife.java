package by.babanin.example1;

import by.babanin.example1.infra.Action;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Wife {
    @Autowired
    private Husband husband;

    private String caress;

    @Action
    public void action() {
        System.out.println("Жена: " + husband.getMoney().toUpperCase() + " важнее, чем " + caress);
    }

    @PostConstruct
    public void init() {
        caress = "ласка";
    }

    public void saySomething() {
        System.out.println("Жена: куда собрался?");
    }

    public String getCaress() {
        return caress;
    }
}
