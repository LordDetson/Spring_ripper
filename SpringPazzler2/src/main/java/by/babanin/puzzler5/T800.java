package by.babanin.puzzler5;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/*
destroy не вызываються у PROTOTYPE!!!
 */
@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class T800 {
    @PostConstruct
    public void init() {
        System.out.println("T800-init()");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("T800-destroy()");
    }
}
