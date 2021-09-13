package com.example.util;

import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Component
public class TimeFormatter {
    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("hh:mm a");

    public String format(LocalTime time) {
        return time.format(dateTimeFormatter);
    }
}
