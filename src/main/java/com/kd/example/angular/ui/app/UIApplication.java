package com.kd.example.angular.ui.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication(scanBasePackages = { "com.kd.example" })
public class UIApplication {

    @SuppressWarnings("unused")
    public static void main(String[] args) throws Exception {
        ApplicationContext context = SpringApplication.run(UIApplication.class, args);
    }
}
