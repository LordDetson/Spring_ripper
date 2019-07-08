package by.babanin;

import by.babanin.quoters.Quoter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
    }
}
