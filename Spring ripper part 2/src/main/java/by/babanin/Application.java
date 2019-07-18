package by.babanin;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ConfigurationClassPostProcessor;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

public class Application {
    public static void main(String[] args) throws InterruptedException {
        /*
        BeanDefinitionDocumentReader считывает описание (определение) бинов из xml,
        кладет описание в BeanDefinitions,
        BeanFactory создает BeanPostProcessor-ы и кладет в сторонку, так как это собобые объекты
        BeanFactory создает singleton бины согласно конфигурации,
        отдает созданный бин BeanPostProcessor-ам,
        BeanPostProcessor возвращает, отданный ему бин, BeanFactory,
        после вызываеться init-method бина,
        BeanFactory отдает бины BeanPostProcessor-ам,
        BeanPostProcessor возвращает бины BeanFactory,
        BeanFactory кладет их в context
         */
        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        System.out.println("----- BeanDefinitionNames ------");
        Arrays.stream(beanDefinitionNames).forEach(System.out::println);

        /*
        Имеет такойже процесс создания бинов, только вместо BeanDefinitionDocumentReader
        имспользуеться ClassPathBeanDefinitionScanner -
        сканирует проект и создает бины на основе все классов с аннотацией @Component
        или аннотацией, аннотированной @Component

        AnnotationConfigApplicationContext context1 = new AnnotationConfigApplicationContext("by/babanin");
        */
        /*
        Имеет такойже процесс создания бинов, только вместо ClassPathBeanDefinitionScanner
        имспользуеться AnnotatedBeanDefinitionReader

        AnnotationConfigApplicationContext context2 = new AnnotationConfigApplicationContext(JavaConfig.class);

        Кто обрабатывает JavaConfig?

        - ConfigurationClassPostProcessor (особый BeanFactoryPostProcessor) - его регестрирует AnnotationConfigApplicationContext

        */
    }
}
