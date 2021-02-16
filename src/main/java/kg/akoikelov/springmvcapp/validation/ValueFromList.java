package kg.akoikelov.springmvcapp.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({METHOD, FIELD, ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = ValueFromListValidator.class)
@Documented
public @interface ValueFromList {
  String message() default "Value is not from list";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};

  String allowedValues();
}
