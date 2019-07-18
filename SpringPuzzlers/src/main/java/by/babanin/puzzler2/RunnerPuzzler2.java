package by.babanin.puzzler2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan("by.babanin.puzzler2")
@EnableAspectJAutoProxy
public class RunnerPuzzler2 {
    @Bean
    public String conference() {
        return "Conference Joker";
    }
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(RunnerPuzzler2.class);
        JokerConfService jokerConfService = applicationContext.getBean(JokerConfService.class);
        jokerConfService.pay();
    }
}
