package com.in28minutes.learnspringframework.examples.a1;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
class YourBusinessClass {

    /*
    Dependency injection types:
    * Constructor-based: Dependencies are set by creating the Bean using its constructor
    * Setter-based: Dependencies are set by calling setter methods on your beans
    * Fields: No setter or constructor.
     */

    /* Fields injection */
//    @Autowired
    private Dependency1 dependency1;
//    @Autowired
    private Dependency2 dependency2;

    /* Constructor injection */
    // @Autowired // Constructor dependency injection you don't need @Autowired
//    public YourBusinessClass(Dependency1 dependency1, Dependency2 dependency2) {
//        System.out.println("Constructor Injection - YourBusinessClass ");
//        this.dependency1 = dependency1;
//        this.dependency2 = dependency2;
//    }

    /* Setter injection */
//        @Autowired
//    public void setDependency1(Dependency1 dependency1) {
//        System.out.println("Setter Injection - setDependency1 ");
//        this.dependency1 = dependency1;
//    }
//
//    @Autowired
//    public void setDependency2(Dependency2 dependency2) {
//        System.out.println("Setter Injection - setDependency2 ");
//        this.dependency2 = dependency2;
//    }

    public String toString() {
        return "Using " + dependency1 + " and " + dependency2;
    }
}

@Component
class Dependency1 {

}

@Component
class Dependency2 {

}


@Configuration
@ComponentScan
public class DepInjectionLauncherApplication {

    public static void main(String[] args) {

        try (var context = new AnnotationConfigApplicationContext(DepInjectionLauncherApplication.class)) {

            Arrays.stream(context.getBeanDefinitionNames())
                    .forEach(System.out::println);

            System.out.println(context.getBean(YourBusinessClass.class));

        }

    }
}
