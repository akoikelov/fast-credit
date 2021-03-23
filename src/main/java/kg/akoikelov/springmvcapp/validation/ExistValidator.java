package kg.akoikelov.springmvcapp.validation;

import kg.akoikelov.springmvcapp.dao.Dao;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ExistValidator implements ConstraintValidator<Exist, Object> {
    @Autowired
    Dao dao;

    String tableName;


    @Override
    public void initialize(Exist constraintAnnotation) {
       tableName= constraintAnnotation.tableName();


    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        return dao.checkById(tableName,(int)o);
    }

}
