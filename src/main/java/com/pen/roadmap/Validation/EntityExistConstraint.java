package com.pen.roadmap.Validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = EntityExistConstraintValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface EntityExistConstraint {
    String message() default "Entity does not exists";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    Class className();

}
