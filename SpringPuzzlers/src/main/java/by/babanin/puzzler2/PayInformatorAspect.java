package by.babanin.puzzler2;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PayInformatorAspect {
    @Pointcut("execution(* by.babanin.puzzler2..*.pay*(..))")
    public void allPayMethods() {}

    @After("allPayMethods()")
    public void info() {
        System.out.println("PayInformatorAspect.info()");
    }
}
