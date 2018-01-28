package com.refuel4.lambda.sample;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import java.text.MessageFormat;
import java.time.LocalDateTime;

public class Hello implements RequestHandler<String, String> {

    @Override
    public String handleRequest(String input, Context context) {
        LambdaLogger logger = context.getLogger();
        logger.log("received : " + input);
        return MessageFormat.format("Hello Lambda! I received your input: {0} at {1}",
                input, LocalDateTime.now());
    }
}
