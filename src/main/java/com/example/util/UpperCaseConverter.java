package com.example.util;

import org.springframework.stereotype.Component;

@Component
public class UpperCaseConverter {

    public String convert(String input) {
        if (input == null)
            return null;
        return input.toUpperCase();
    }

}
