package by.babanin.puzzler5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class T1000 {
    @Autowired
    private T800 t800;

    @PostConstruct
    public void init() {
        System.out.println("T1000-init()");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("T1000-destroy()");
    }
}
