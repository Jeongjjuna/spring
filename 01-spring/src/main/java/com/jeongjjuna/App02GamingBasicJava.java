package com.jeongjjuna;

import com.jeongjjuna.hellosrping.HelloWorldConfiguration;
import com.jeongjjuna.hellosrping.Address;
import com.jeongjjuna.hellosrping.Person;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class App02GamingBasicJava {
    public static void main(String[] args) {
        // HelloWorldConfiguration 에서 등록한 빈들을 스프링 컨테이너에서 사용하겠다/관리하겠다.
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class);

        System.out.println(context.getBean("person2MethodCall"));
        System.out.println(context.getBean("person3Parameters"));
        System.out.println(context.getBean("address2"));

        // 빈으로 설정한 Address 객체가 여러개이므로 안됨. NoUniqueBeanDefinitionException 발생
        // -> 1. @Primary 통해 기본빈 설정을 해준다. 2. @Qualifier 사용
        // System.out.println(context.getBean(Address.class));
        // System.out.println(context.getBean(Person.class));


        System.out.println("--------------");

        // 스프링이 관리하는 모든 빈을 가져오기
        Arrays.stream(context.getBeanDefinitionNames())
                .forEach(System.out::println);

    }
}
