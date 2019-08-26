package by.babanin.springRipper.MoneyRaven;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Arrays;

@SpringBootApplication
public class MoneyRavenApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(MoneyRavenApplication.class, args);
		String[] beanDefinitionNames = run.getBeanDefinitionNames();
		Arrays.stream(beanDefinitionNames).forEach(System.out::println);
	}

}
