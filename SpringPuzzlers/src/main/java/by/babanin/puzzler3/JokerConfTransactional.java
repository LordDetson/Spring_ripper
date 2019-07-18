package by.babanin.puzzler3;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Transactional
public @interface JokerConfTransactional {
    Propagation propagation() default Propagation.REQUIRES_NEW;
}
