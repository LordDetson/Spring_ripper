package by.babanin;

import by.babanin.quoters.InjectRandomInit;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Random;
/*
Зачем нужно 2 метода в BeanPostProcessor?

Когда обьъекту нужно добавить логику на лету, то используеться механизм Dynamic Proxy.
Но после тогда как мы создадим прокси объекта, все метаданные сотруться.

По этой причине в методе postProcessBeforeInitialization мы работыем с оригинальными объектами.
А в postProcessAfterInitialization мы можем работать уже с прокси-объектами.
 */
public class InjectRandomInitAnnotationBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Field[] fields = bean.getClass().getDeclaredFields();
        Arrays.stream(fields).forEach(field -> {
            InjectRandomInit annotation = field.getAnnotation(InjectRandomInit.class);
            if (annotation != null) {
                int min = annotation.min();
                int max = annotation.max();
                Random random = new Random();
                int i = min + random.nextInt(max - min);
                field.setAccessible(true);
                ReflectionUtils.setField(field, bean, i);
            }
        });
        for (Field field : fields) {
            field.getAnnotations();
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
