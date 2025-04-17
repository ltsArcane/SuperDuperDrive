package com.udacity.jwdnd.course1.cloudstorage.config;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.time.LocalDate;

@ControllerAdvice
public class GlobalModelAttributes {
    @ModelAttribute("currentYear")
    public int currentYear() { return LocalDate.now().getYear(); }
}