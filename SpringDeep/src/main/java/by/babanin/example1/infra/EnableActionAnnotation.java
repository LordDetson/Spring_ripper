package by.babanin.example1.infra;

import org.springframework.context.annotation.Import;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Import(ActionAnnotationConfig.class)
public @interface EnableActionAnnotation {
}
