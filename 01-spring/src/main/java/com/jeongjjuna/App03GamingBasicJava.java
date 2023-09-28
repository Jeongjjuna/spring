package com.jeongjjuna;

import com.jeongjjuna.game.GameRunner;
import com.jeongjjuna.game.GamingConsole;
import com.jeongjjuna.springgame.GamingConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App03GamingBasicJava {
    public static void main(String[] args) {


        try(AnnotationConfigApplicationContext context =
                    new AnnotationConfigApplicationContext(GamingConfiguration.class)) {

            Object console1 = context.getBean("gamingConsole");
            GamingConsole console2 = context.getBean("gamingConsole", GamingConsole.class);

            context.getBean(GamingConsole.class).up();
            context.getBean(GameRunner.class).run();

        }


    }
}
