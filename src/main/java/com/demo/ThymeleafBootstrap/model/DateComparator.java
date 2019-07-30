package com.demo.ThymeleafBootstrap.model;

import com.demo.ThymeleafBootstrap.validator.DateComparatorDateConstraint;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDate;

@DateComparatorDateConstraint(firstDate = "startDate",secondDate = "endDate")

public class DateComparator {

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}
