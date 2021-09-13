package com.example.function.handler;

import com.example.util.TimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.util.function.Function;

import static java.lang.String.format;

/**
 * This is the function binding class. The bean name must be same as the function name and the class must implement java.util.function.Function<T, R>
 */
@Component("time")
public class TimeHandler implements Function<String, String> {
    @Autowired
    TimeFormatter timeFormatter;

    /**
     * This method will be automatically invoked and the function business logic goes here
     */
    @Override
    public String apply(String name) {
        return format("Time: %s", timeFormatter.format(LocalTime.now()));
    }
}
