package com.jeongjjuna.springgame;

import com.jeongjjuna.game.GameRunner;
import com.jeongjjuna.game.GamingConsole;
import com.jeongjjuna.game.PacmanGame;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GamingConfiguration {

    @Bean
    public GameRunner gameRunner(GamingConsole game) {
        GameRunner gameRunner = new GameRunner(game);
        return gameRunner;
    }

    @Bean
    public GamingConsole gamingConsole() {
        GamingConsole game = new PacmanGame();
        return game;
    }

}
