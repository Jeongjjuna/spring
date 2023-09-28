package com.jeongjjuna.dependencyinjection;


import com.jeongjjuna.config.GamingConfiguration;
import com.jeongjjuna.game.GameRunner;
import com.jeongjjuna.game.GamingConsole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
class YourBusinessClass {

    Dependency1 dependency1;
    Dependency2 dependency2;

    // 생성자 주입
    public YourBusinessClass(Dependency1 dependency1, Dependency2 dependency2) {
        this.dependency1 = dependency1;
        this.dependency2 = dependency2;
    }

    public void test() {
        System.out.println(dependency1);
        System.out.println(dependency2);
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

        try(AnnotationConfigApplicationContext context =
                    new AnnotationConfigApplicationContext(DepInjectionLauncherApplication.class)) {

            Arrays.stream(context.getBeanDefinitionNames())
                    .forEach(System.out::println);

            context.getBean(YourBusinessClass.class).test();
        }

    }
}
