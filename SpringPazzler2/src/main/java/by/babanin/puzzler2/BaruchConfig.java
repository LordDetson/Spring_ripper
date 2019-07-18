package by.babanin.puzzler2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BaruchConfig {
    @Bean
    @BaruchQualifier
    public String str1() {
        return "Groovy";
    }

    @Bean
    @BaruchQualifier
    public String str2() {
        return "Spring";
    }

    @Bean
    @BaruchQualifier
    public String str3() {
        return "Artifactory";
    }
}
