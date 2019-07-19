package by.babanin.puzzler3.genre;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Comedy @Action @Melodram
public @interface AnyGenre {
}
