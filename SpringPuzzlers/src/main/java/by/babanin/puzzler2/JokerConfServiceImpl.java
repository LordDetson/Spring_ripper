package by.babanin.puzzler2;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class JokerConfServiceImpl implements JokerConfService {
    private final String conference;

    public JokerConfServiceImpl(String conference) {
        this.conference = conference;
    }

    @PostConstruct
    public void setup() {
        System.out.println("JokerConfServiceImpl.setup()");
    }

    @Audit
    public void pay() {
        System.out.println("JokerConfServiceImpl.pay()");
    }
}
