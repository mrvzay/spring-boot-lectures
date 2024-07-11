package com.in28minutes.learnspringframework.examples.f1;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
class SomeClass {

    private SomeDependency someDependency;

    public SomeClass(SomeDependency someDependency) {
        this.someDependency = someDependency;
        System.out.println("All dependency are ready!");
    }

    @PostConstruct          // After constructor call
    public void initialize() {
        someDependency.getReady();
    }

    @PreDestroy         // Last call
    public void cleanup() {
        System.out.println("Cleanup");
    }
}

@Component
class SomeDependency {

    public void getReady() {
        System.out.println("Some logic using SomeDependency");
    }
}

@Configuration
@ComponentScan
public class PrePostAnnotationsContextLauncherApplication {

    public static void main(String[] args) {

        try (var context = new AnnotationConfigApplicationContext(PrePostAnnotationsContextLauncherApplication.class)) {

            Arrays.stream(context.getBeanDefinitionNames())
                    .forEach(System.out::println);

        }

    }
}
