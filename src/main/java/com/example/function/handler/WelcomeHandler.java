package com.example.function.handler;

import com.example.util.UpperCaseConverter;
import com.microsoft.azure.functions.ExecutionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import java.util.function.Function;

/**
 * This is the function binding class.
 */

@Component
public class WelcomeHandler {
    private final UpperCaseConverter upperCaseConverter;

    @Autowired
    public WelcomeHandler(UpperCaseConverter upperCaseConverter) {
        this.upperCaseConverter = upperCaseConverter;
    }


    /**
     * This method will be automatically invoked and the function business logic goes here
     */
    @Bean
    public Function<Message<String>, String> welcome() {
        return message -> {
            ExecutionContext context = (ExecutionContext) message.getHeaders().get("executionContext");
            context.getLogger().info("Function execution context can be accessed from here!");
            return "Welcome Mr " + upperCaseConverter.convert(message.getPayload());
        };
    }
}
