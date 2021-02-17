package kg.akoikelov.springmvcapp.validation;

import org.springframework.beans.BeanWrapperImpl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class FieldsValueMatchValidator implements ConstraintValidator<FieldsValueMatch, Object> {
  private String field;
  private String fieldMatch;
  private String message;

  public void initialize(FieldsValueMatch constraintAnnotation) {
    this.field = constraintAnnotation.field();
    this.fieldMatch = constraintAnnotation.fieldMatch();
    this.message = constraintAnnotation.message();
  }

  public boolean isValid(Object value, ConstraintValidatorContext context) {

    boolean valid = true;

    try {
      final Object firstObj = new BeanWrapperImpl(value).getPropertyValue(field);
      final Object secondObj = new BeanWrapperImpl(value).getPropertyValue(fieldMatch);

      valid =
          firstObj == null && secondObj == null || firstObj != null && firstObj.equals(secondObj);
    } catch (final Exception ignore) {
      // ignore
    }

    if (!valid) {
      context
          .buildConstraintViolationWithTemplate(message)
          .addPropertyNode(field)
          .addConstraintViolation()
          .disableDefaultConstraintViolation();
    }

    return valid;
  }
}
