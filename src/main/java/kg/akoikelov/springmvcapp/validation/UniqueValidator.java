package kg.akoikelov.springmvcapp.validation;

import kg.akoikelov.springmvcapp.dao.FieldValueExists;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueValidator implements ConstraintValidator<Unique, Object> {
  @Autowired private ApplicationContext applicationContext;

  private FieldValueExists dao;
  private String fieldName;
  private String message;

  @Override
  public void initialize(Unique unique) {
    Class<? extends FieldValueExists> clazz = unique.service();
    this.fieldName = unique.fieldName();
    this.message = unique.message();
    String serviceQualifier = unique.serviceQualifier();

    if (!serviceQualifier.equals("")) {
      this.dao = this.applicationContext.getBean(serviceQualifier, clazz);
    } else {
      this.dao = this.applicationContext.getBean(clazz);
    }
  }

  @Override
  public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
    final Object fieldValue = new BeanWrapperImpl(o).getPropertyValue(fieldName);
    final Object id = new BeanWrapperImpl(o).getPropertyValue("id");
    boolean valid = !this.dao.fieldValueExists(fieldName, fieldValue, (int) id);
    if (!valid) {
      constraintValidatorContext
          .buildConstraintViolationWithTemplate(message)
          .addPropertyNode(fieldName)
          .addConstraintViolation()
          .disableDefaultConstraintViolation();
    }

    return valid;
  }
}
