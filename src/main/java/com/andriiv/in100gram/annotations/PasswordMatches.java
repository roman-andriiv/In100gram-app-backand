package com.andriiv.in100gram.annotations;

import com.andriiv.in100gram.validations.EmailValidator;
import com.andriiv.in100gram.validations.PasswordMatchesValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

/**
 * Created by Roman Andriiv (30.04.2023 - 14:24)
 */
@Target({ElementType.TYPE, ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PasswordMatchesValidator.class)
@Documented
public @interface PasswordMatches {

    String message() default "Password do not match";

    Class<?>[] groups() default{};

    Class<? extends Payload>[] payload()default {};
}
