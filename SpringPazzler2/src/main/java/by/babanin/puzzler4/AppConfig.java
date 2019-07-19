package by.babanin.puzzler4;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import javax.annotation.PostConstruct;

@Configuration
public class AppConfig {
    @Value("${JAVA_HOME}")
    private String javaHome;

    @PostConstruct
    public void init() {
        System.out.println(javaHome);
    }
    /*
    Warning:
    PropertySourcesPlaceholderConfigurer являеться BeanFactoryPostProcessor и плохо,
    что ты его создаешь не через статический метод
     */
    /* @Bean
    public PropertySourcesPlaceholderConfigurer configurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }*/
}
