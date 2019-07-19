package by.babanin.puzzler4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("by.babanin.puzzler4")
//@PropertySource("")
public class RunnerPuzzler4 {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(RunnerPuzzler4.class);
        SomeService bean = applicationContext.getBean(SomeService.class);
    }
}
