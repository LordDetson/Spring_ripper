package by.babanin.puzzler2;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
Правило: Все проксирование засовываем в postProcessAfterInitialization, так как можем сломать BeanPostProcessor-ы спринга

Если используються аспекты, то надо знать, что аспекты срабатывают во время инициализации бина. Из этого следует
правило: не привязываться к bean.getClass(), так как есть вероятность получить Proxy.
Для этого испольуем мапу для запоминания оригинальных классов до инициализации бина.
 */

@Component
public class AuditAnnotationHandlerBeanPostProcessor implements BeanPostProcessor {
    private final AuditManager auditManager;
    private Map<String, Class> map;

    public AuditAnnotationHandlerBeanPostProcessor(AuditManager auditManager) {
        this.auditManager = auditManager;
        map = new HashMap<>();
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Class<?> beanClass = bean.getClass();
        Method[] methods = beanClass.getMethods();
        boolean isAnnotationAudit = Arrays.stream(methods)
                .anyMatch(method -> method.isAnnotationPresent(Audit.class));
        if (isAnnotationAudit) map.put(beanName, beanClass);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (map.containsKey(beanName)) {
            Class beanClass = map.get(beanName);
            return Proxy.newProxyInstance(beanClass.getClassLoader(), beanClass.getInterfaces(), (proxy, method, args) -> {
                Object invoke = method.invoke(bean, args);
                auditManager.audit();
                return invoke;
            });
        }
        return bean;
    }
}
