package com.example.securewebapp.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordStrengthValidator
        implements ConstraintValidator<StrongPassword, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) return false;

        boolean hasUpper = value.matches(".*[A-Z].*");
        boolean hasLower = value.matches(".*[a-z].*");
        boolean hasDigit = value.matches(".*\\d.*");

        return hasUpper && hasLower && hasDigit;
    }
}
