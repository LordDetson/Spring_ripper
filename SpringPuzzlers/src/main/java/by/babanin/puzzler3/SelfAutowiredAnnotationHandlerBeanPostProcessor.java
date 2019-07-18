package by.babanin.puzzler3;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Component
public class SelfAutowiredAnnotationHandlerBeanPostProcessor implements BeanPostProcessor, Ordered {
    private Map<String, Object> map = new HashMap<>();

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Field[] fields = bean.getClass().getDeclaredFields();
        boolean isAnnotationSelfAutowired = Arrays.stream(fields).anyMatch(field -> field.isAnnotationPresent(SelfAutowired.class));
        if (isAnnotationSelfAutowired)
            map.put(beanName, bean);
        return bean;
    }

    /*
    В объект инжектим самого себя в поле с аннотацией @SelfAutowired
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (map.containsKey(beanName)) {
            Object originalBean = map.get(beanName);
            Field[] fields = originalBean.getClass().getDeclaredFields();
            Arrays.stream(fields).filter(field -> field.isAnnotationPresent(SelfAutowired.class)).forEach(field -> {
                field.setAccessible(true);
                ReflectionUtils.setField(field, originalBean, bean);
            });

        }
        return bean;
    }

    /*
    Делаем так, что этот BeanPostProcessor вызывался самым последним.
     */
    @Override
    public int getOrder() {
        return LOWEST_PRECEDENCE;
    }
}
