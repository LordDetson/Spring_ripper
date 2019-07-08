package by.babanin;

import by.babanin.quoters.PostProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import java.lang.reflect.Method;
import java.util.Arrays;

public class PostProxyInvokerContextListener implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private ConfigurableListableBeanFactory beanFactory;

    public void setBeanFactory(ConfigurableListableBeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        ApplicationContext context = contextRefreshedEvent.getApplicationContext();
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        Arrays.stream(beanDefinitionNames).forEach(name -> {
            BeanDefinition beanDefinition = beanFactory.getBeanDefinition(name);
            String originalBeanClassName = beanDefinition.getBeanClassName();
            try {
                Class<?> originalClass = Class.forName(originalBeanClassName);
                Method[] methods = originalClass.getMethods();
                Arrays.stream(methods).forEach(method -> {
                    if (method.isAnnotationPresent(PostProxy.class)) {
                        Object bean = context.getBean(name);
                        try {
                            Method currentMethod = bean.getClass().getMethod(method.getName(), method.getParameterTypes());
                            currentMethod.invoke(bean);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        });
    }
}
