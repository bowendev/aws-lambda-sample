package com.refuel4.lambda.sample;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.SNSEvent;
import com.refuel4.lambda.sample.configuration.AppSettings;
import com.refuel4.lambda.sample.configuration.IAppSettings;

import java.text.MessageFormat;
import java.time.LocalDateTime;

public class HelloSNS implements RequestHandler<SNSEvent, String> {

    private static final IAppSettings appSettings = AppSettings.getInstance();

    @Override
    public String handleRequest(SNSEvent event, Context context) {
        String message = event.getRecords().get(0).getSNS().getMessage();
        LambdaLogger logger = context.getLogger();
        logger.log("received : " + message + "\n");
        logger.log("AppSettings are null: " + (appSettings == null) + "\n");
        if (appSettings != null) {
            logger.log("Service name: " + appSettings.getServiceName() + "\n");
        }
        return MessageFormat.format("Hello Lambda! I received your input: {0} at {1}",
                message, LocalDateTime.now());
    }
}
