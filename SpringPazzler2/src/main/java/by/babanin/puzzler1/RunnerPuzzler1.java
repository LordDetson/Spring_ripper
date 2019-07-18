package by.babanin.puzzler1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("by.babanin.puzzler1")
public class RunnerPuzzler1 {
    @Bean
    public Iron iron() {
        return new IronConfigImpl();
    }

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(RunnerPuzzler1.class);
    }
}
