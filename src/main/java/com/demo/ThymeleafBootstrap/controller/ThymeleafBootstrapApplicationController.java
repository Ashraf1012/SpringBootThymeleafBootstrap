package com.demo.ThymeleafBootstrap.controller;

import com.demo.ThymeleafBootstrap.model.DateComparator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.time.Period;

@Controller
public class ThymeleafBootstrapApplicationController {
    @Autowired
    public ThymeleafBootstrapApplicationController() {
    }

    @RequestMapping("/")
    public String index(Model model){
        model.addAttribute("dateComparator", new DateComparator());
        return "index";
    }

    @PostMapping("/")
    public String compareDates(@Valid DateComparator dateComparator, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors())
        {
            return "index";
        }

        Period period = Period.between(dateComparator.getStartDate(),dateComparator.getEndDate());
        model.addAttribute("successMessage", period.getDays() + " day(s) between start date and end date!");
        return "index";
    }
}
