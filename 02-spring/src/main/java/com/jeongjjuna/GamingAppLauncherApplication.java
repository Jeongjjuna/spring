package com.jeongjjuna;

import com.jeongjjuna.config.GamingConfiguration;
import com.jeongjjuna.game.GameRunner;
import com.jeongjjuna.game.GamingConsole;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class GamingAppLauncherApplication {
    public static void main(String[] args) {


        try(AnnotationConfigApplicationContext context =
                    new AnnotationConfigApplicationContext(GamingConfiguration.class)) {

            context.getBean(GamingConsole.class).up();
            System.out.println("-------");
            context.getBean(GameRunner.class).run();

        }


    }
}
