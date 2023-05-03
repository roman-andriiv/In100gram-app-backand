package com.andriiv.in100gram.validations;

import com.andriiv.in100gram.annotations.PasswordMatches;
import com.andriiv.in100gram.payload.request.SignupRequest;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

/**
 * Created by Roman Andriiv (30.04.2023 - 14:28)
 */
public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> {

    @Override
    public void initialize(PasswordMatches constraintAnnotation) {

    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        SignupRequest signupRequest = (SignupRequest) o;
        return signupRequest.getPassword().equals(signupRequest.getConfirmPassword());
    }
}
