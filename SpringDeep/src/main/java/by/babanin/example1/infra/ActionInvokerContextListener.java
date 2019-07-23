package by.babanin.example1.infra;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;

import java.lang.reflect.Method;
import java.util.Arrays;

public class ActionInvokerContextListener {
    private final ConfigurableListableBeanFactory beanFactory;

    public ActionInvokerContextListener(ConfigurableListableBeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    @EventListener
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        String[] beanDefinitionNames = beanFactory.getBeanDefinitionNames();
        Arrays.stream(beanDefinitionNames).forEach(name -> {
            BeanDefinition beanDefinition = beanFactory.getBeanDefinition(name);
            String beanClassName = beanDefinition.getBeanClassName();
            if (beanClassName != null) {
                try {
                    Class<?> beanClass = Class.forName(beanClassName);
                    Method[] methods = beanClass.getMethods();
                    ApplicationContext context = contextRefreshedEvent.getApplicationContext();
                    Arrays.stream(methods).filter(method -> method.isAnnotationPresent(Action.class)).forEach(method -> {
                        Object bean = context.getBean(name);
                        try {
                            Method currentMethod = bean.getClass().getMethod(method.getName(), method.getParameterTypes());
                            currentMethod.invoke(bean);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
