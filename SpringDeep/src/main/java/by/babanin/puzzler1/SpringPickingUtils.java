package by.babanin.puzzler1;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.core.type.StandardMethodMetadata;

import java.lang.reflect.Field;

/*
Так как в javaConfig в BeanDefinition отсудствует названия класса,
то мы достаем возвращаемый класс из ConfigurationClassBeanDefinition.

Можно было бы достать из бина, но мы идем на такие ухищрения, так как нам нужно узнать класс до создания бина
 */
public class SpringPickingUtils {
    public static String resolveClassNameFromJavaConfig(BeanDefinition beanDefinition) {
        try {
            Object reader = Class.forName("org.springframework.context.annotation.ConfigurationClassBeanDefinitionReader$ConfigurationClassBeanDefinition").cast(beanDefinition);
            Field field = reader.getClass().getDeclaredField("factoryMethodMetadata");
            field.setAccessible(true);
            StandardMethodMetadata visitor = (StandardMethodMetadata) field.get(reader);
            return visitor.getReturnTypeName();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
