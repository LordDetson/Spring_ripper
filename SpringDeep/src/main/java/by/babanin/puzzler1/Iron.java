package by.babanin.puzzler1;

import javax.annotation.PostConstruct;

/*
Запускаються оба @PostConstruct так как с версии Spring 4.2 он сам поддерживает @PostConstruct default методы в интерфейсах.
Иногда бывают случаи, что мне повезло и у меня в InitMathodRegistryBeanFactoryPostProcessor зарегестрировался
@PostConstruct метод не default и запускаеться оба метода.
Или не повезло и запускаеться только @PostConstruct default.
 */
public interface Iron {
    @PostConstruct
    void heat();

    @PostConstruct
    default void foo() {
        System.out.println("CONNECTING...");
    }
}
