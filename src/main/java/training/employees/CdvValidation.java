package training.employees;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({FIELD})
@Retention(RUNTIME)

@Constraint(validatedBy = CdvValidator.class)
public @interface CdvValidation {

    String message() default "Ervenytelen adoszam";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
