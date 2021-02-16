package kg.akoikelov.springmvcapp.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;

public class ValueFromListValidator implements ConstraintValidator<ValueFromList, Object> {

  private String allowedValues;

  @Override
  public void initialize(ValueFromList constraintAnnotation) {
    this.allowedValues = constraintAnnotation.allowedValues();
  }

  @Override
  public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
    return Arrays.asList(allowedValues.split(",")).contains(o);
  }
}
