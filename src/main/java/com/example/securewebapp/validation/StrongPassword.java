package com.example.securewebapp.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

@Constraint(validatedBy = PasswordStrengthValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface StrongPassword {

    String message() default "Password must contain uppercase, lowercase and digit";

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
