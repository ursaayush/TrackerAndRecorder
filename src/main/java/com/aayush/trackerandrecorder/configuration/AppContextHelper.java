package com.aayush.trackerandrecorder.configuration;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * Created by aayush on 24/07/14.
 */
@Component
public class AppContextHelper implements ApplicationContextAware{

    private static ApplicationContext ctx;

    public void setApplicationContext(ApplicationContext appContext)
            throws BeansException {
        ctx = appContext;

    }

    public static ApplicationContext getApplicationContext() {
        return ctx;
    }
}
