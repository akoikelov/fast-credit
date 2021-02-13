package kg.akoikelov.springmvcapp.validation;

import kg.akoikelov.springmvcapp.dao.FieldValueExists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class UniqueValidator implements ConstraintValidator<Unique, Object> {
    @Autowired
    private ApplicationContext applicationContext;

    private FieldValueExists dao;
    private String fieldName;

    @Override
    public void initialize(Unique unique) {
        Class<? extends FieldValueExists> clazz = unique.service();
        this.fieldName = unique.fieldName();
        String serviceQualifier = unique.serviceQualifier();

        if (!serviceQualifier.equals("")) {
            this.dao = this.applicationContext.getBean(serviceQualifier, clazz);
        } else {
            this.dao = this.applicationContext.getBean(clazz);
        }
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        return !this.dao.fieldValueExists(this.fieldName, o);
    }
}
