package BooksWorld.Validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.PropertyAccessorFactory;

import java.util.Objects;

public class EqualPasswordValidator implements ConstraintValidator<EqualPassword, Object> {
    private String first;
    private String second;
    private String message;
    @Override
    public void initialize(EqualPassword constraintAnnotation) {
        this.first=constraintAnnotation.first();
        this.second=constraintAnnotation.second();
        this.message=constraintAnnotation.message();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        BeanWrapper beanWrapper = PropertyAccessorFactory.forBeanPropertyAccess(value);

        Object firstProperty = beanWrapper.getPropertyValue(this.first);
        Object secondProperty = beanWrapper.getPropertyValue(this.second);
        boolean isValid = Objects.equals(firstProperty, secondProperty);
        if (!isValid) {
            context.buildConstraintViolationWithTemplate(message)
                    .addPropertyNode(second)
                    .addConstraintViolation()
                    .disableDefaultConstraintViolation();
        }

        return isValid;
    }
}
