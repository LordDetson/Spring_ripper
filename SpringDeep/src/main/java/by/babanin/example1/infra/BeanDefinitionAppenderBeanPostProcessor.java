package by.babanin.example1.infra;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

import java.util.Arrays;

public class BeanDefinitionAppenderBeanPostProcessor implements BeanPostProcessor {

    private final ConfigurableListableBeanFactory beanFactory;

    public BeanDefinitionAppenderBeanPostProcessor(ConfigurableListableBeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    /*
    В Spring Boot все ломаеться!!! Так как BeanPostProcessor не имеет права брать BeanDefinition и коректировать их.
    Чтобы это починить надо чинить только те бины, которые имеют @Action, чтобы запускать их после поднятия контекста.
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (neededActionBehavior(bean)) {
            BeanDefinition beanDefinition = beanFactory.getBeanDefinition(beanName);
            if (beanDefinition.getBeanClassName() == null) {
                beanDefinition.setBeanClassName(bean.getClass().getCanonicalName());
            }
        }
        return bean;
    }

    private boolean neededActionBehavior(Object bean) {
        return Arrays.stream(bean.getClass().getMethods()).anyMatch(method -> method.isAnnotationPresent(Action.class));
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
