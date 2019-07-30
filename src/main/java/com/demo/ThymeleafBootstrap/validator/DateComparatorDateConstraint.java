package com.demo.ThymeleafBootstrap.validator;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Constraint(validatedBy = DateComparatorDateValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface DateComparatorDateConstraint {
    String message() default "{validation.dateComparatorDateConstraint.startDate.message}";
    String firstDate();
    String secondDate();

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
