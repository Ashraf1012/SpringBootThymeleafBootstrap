package com.demo.ThymeleafBootstrap.validator;

import org.springframework.beans.BeanWrapperImpl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;

public class DateComparatorDateValidator implements ConstraintValidator<DateComparatorDateConstraint,Object> {

    private String firstDate;
    private String secondDate;

    @Override
    public boolean isValid(Object value , ConstraintValidatorContext constraintValidatorContext) {
        Object startDateStringObj = new BeanWrapperImpl(value).getPropertyValue(firstDate);
        Object endDateStringObj = new BeanWrapperImpl(value).getPropertyValue(secondDate);

        LocalDate startDate = (LocalDate) startDateStringObj;
        LocalDate endDate = (LocalDate) endDateStringObj;
        return endDate.isAfter(startDate) || endDate.isEqual(startDate);
    }

    @Override
    public void initialize(DateComparatorDateConstraint dateComparatorDateConstraint) {
        firstDate = dateComparatorDateConstraint.firstDate();
        secondDate = dateComparatorDateConstraint.secondDate();
    }
}
