package com.example.function;

import com.microsoft.azure.functions.ExecutionContext;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.azure.functions.annotation.TimerTrigger;
import org.springframework.cloud.function.adapter.azure.FunctionInvoker;
/**
 * This is the function class and must inherit org.springframework.cloud.function.adapter.azure.FunctionInvoker<I, O>
 */
public class TimeFunction extends FunctionInvoker<String, String> {
    /**
     *  Timer trigger function that runs on every 2 minutes and print the current time
     */
    @FunctionName("time")
    public void run(
            @TimerTrigger(name = "timer", schedule = "0 */2 * * * *") String timerInfo,
            ExecutionContext context
    ) {
        context.getLogger().info("Time function starting to process request");
        String result = handleRequest(timerInfo, context);
        context.getLogger().info(result);
        context.getLogger().info("Time function run successfully");
    }
}
