package com.academicbot.Helpers;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContext {
    static AbstractApplicationContext context;
    private ApplicationContext(){};

    public static AbstractApplicationContext getContext() {
        if (context == null)     {
            context = new ClassPathXmlApplicationContext("AcademicBotConfig.xml");
        }
        return  context;
    }
}
