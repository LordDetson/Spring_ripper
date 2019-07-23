package by.babanin.puzzler1;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.stereotype.Component;
import org.springframework.util.ClassUtils;

import javax.annotation.PostConstruct;
import java.lang.reflect.Method;
import java.util.Arrays;

@Component
public class InitMathodRegistryBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        String[] beanDefinitionNames = beanFactory.getBeanDefinitionNames();
        Arrays.stream(beanDefinitionNames).forEach(name -> {
            AbstractBeanDefinition beanDefinition = (AbstractBeanDefinition) beanFactory.getBeanDefinition(name);
            String beanClassName = beanDefinition.getBeanClassName();
            if (beanClassName == null)
                beanClassName = SpringPickingUtils.resolveClassNameFromJavaConfig(beanDefinition);
            Class<?> beanClass = ClassUtils.resolveClassName(beanClassName, ClassLoader.getSystemClassLoader());
            Class<?>[] interfacesForClass = ClassUtils.getAllInterfacesForClass(beanClass);
            Arrays.stream(interfacesForClass).forEach(ifc -> {
                Method[] methods = ifc.getMethods();
                Arrays.stream(methods).forEach(method -> {
                    boolean isAnnotationPostConstruct = method.isAnnotationPresent(PostConstruct.class);
                    boolean isNotDefault = !method.isDefault();
                    if (isAnnotationPostConstruct && isNotDefault) {
                        beanDefinition.setInitMethodName(method.getName());
                    }
                });
            });
        });
    }
}
