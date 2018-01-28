package com.refuel4.lambda.sample.configuration;

import java.util.ResourceBundle;

public class AppSettings implements IAppSettings{
    private static ResourceBundle config = ResourceBundle.getBundle("application");
    private static final AppSettings instance = new AppSettings();

    private AppSettings() {
    }

    public static AppSettings getInstance() {
        return instance;
    }

    @Override
    public String getServiceName() {
        return config.getString("service.name");
    }
}
