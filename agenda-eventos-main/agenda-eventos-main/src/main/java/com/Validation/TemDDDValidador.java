package com.Validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class TemDDDValidador implements ConstraintValidator<DeveTerUmDDD, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
       if (value == null || value.isEmpty()) return false;{
        return value.matches("141");
        
       }
    }

}
