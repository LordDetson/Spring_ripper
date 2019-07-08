package by.babanin.quoters;

import javax.annotation.PostConstruct;

@Profiling
public class TerminatorQuoter implements Quoter {
    @InjectRandomInit(min = 2, max = 7)
    private int repeat;
    private String message;

    public TerminatorQuoter() {
        System.out.println("Phase 1");
    }

    @PostConstruct
    public void init() {
        System.out.println("Phase 2");
        System.out.println(repeat);
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    @PostProxy
    public void sayQuote() {
        System.out.println("Phase 3");
        for (int i = 0; i < repeat; i++) {
            System.out.println(message);
        }
    }
}
