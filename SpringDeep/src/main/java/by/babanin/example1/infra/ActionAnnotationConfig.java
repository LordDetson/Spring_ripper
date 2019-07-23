package by.babanin.example1.infra;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ActionAnnotationConfig {

    @Bean
    public ActionInvokerContextListener actionInvokerContextListener(ConfigurableListableBeanFactory beanFactory) {
        return new ActionInvokerContextListener(beanFactory);
    }

    @Bean
    BeanDefinitionAppenderBeanPostProcessor beanDefinitionAppenderBeanPostProcessor(ConfigurableListableBeanFactory beanFactory) {
        return new BeanDefinitionAppenderBeanPostProcessor(beanFactory);
    }
}
