package com.example.function;

import com.microsoft.azure.functions.*;
import com.microsoft.azure.functions.annotation.AuthorizationLevel;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.azure.functions.annotation.HttpTrigger;
import org.springframework.cloud.function.adapter.azure.FunctionInvoker;

/**
 * This is the function class and must inherit org.springframework.cloud.function.adapter.azure.FunctionInvoker<I, O>
 */
public class WelcomeFunction extends FunctionInvoker<String, String> {

    @FunctionName("welcome")
    public HttpResponseMessage run(
            @HttpTrigger(
                    name = "request",
                    methods = HttpMethod.GET,
                    authLevel = AuthorizationLevel.ANONYMOUS) HttpRequestMessage<String> request,
            ExecutionContext context) {
        context.getLogger().info("Function starting to process request");
        String name = request.getQueryParameters().getOrDefault("name", "x");
        return request
                .createResponseBuilder(HttpStatus.OK)
                // handleRequest() will delegate the execution to apply() of a bean with the same name of the function
                .body(handleRequest(name, context))
                .header("Content-Type", "application/json")
                .build();
    }
}
