package by.babanin.puzzler4;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SomeService {
    @Value("${JAVA_HOME}")
    private void init(String javaHome) {
        System.out.println(javaHome);
    }
}
