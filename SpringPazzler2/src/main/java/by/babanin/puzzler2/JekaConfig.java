package by.babanin.puzzler2;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class JekaConfig {
    @Bean
    @JekaQualifier
    public List<String> message() {
        List<String> list = new ArrayList<>();
        list.add("Java");
        list.add("Thread");
        return list;
    }
}
