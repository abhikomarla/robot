package com.abhijith.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.abhijith.test"})
public class RobotApplication {

    public static void main(String args[]) {

        ApplicationContext context = new AnnotationConfigApplicationContext(RobotApplication.class);

        RobotOrchestrator orchestrator = context.getBean(RobotOrchestrator.class);
        orchestrator.start();
    }
}
