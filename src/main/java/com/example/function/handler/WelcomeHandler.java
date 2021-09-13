package com.example.function.handler;

import com.example.util.UpperCaseConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.function.Function;

import static java.lang.String.format;

/**
 * This is the function binding class. The bean name must be same as the function name and the class must implement java.util.function.Function<T, R>
 */

@Component("welcome")
public class WelcomeHandler implements Function<String, String> {

    @Autowired
    UpperCaseConverter upperCaseConverter;

    /**
     * This method will be automatically invoked and the function business logic goes here
     */
    @Override
    public String apply(String name) {
        return format("Hello, Welcome  %s", upperCaseConverter.convert(name));
    }
}
