package com.example.springRestAWS.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.PARAMETER,})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy=ValidCreatedByValidator.class)
@Documented
public @interface ValidCreatedBy {
    String message() default "Invalid input. Input must only contain a-z 0-9.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}


