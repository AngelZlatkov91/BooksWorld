package BooksWorld.Validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = UserEmailValidator.class)
public @interface UniqueUserEmail {
    String message() default "User with this email is exist!";
    Class<?>[] groups()default {};

    Class<? extends Payload>[] payload() default {};
}
