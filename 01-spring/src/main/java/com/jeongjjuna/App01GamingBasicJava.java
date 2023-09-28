package com.jeongjjuna;

import com.jeongjjuna.game.*;

public class App01GamingBasicJava {
    public static void main(String[] args) {

        // GamingConsole game = new MarioGame();
        // GamingConsole game = new PacmanGame();
        GamingConsole game = new SuperContraGame();

        GameRunner gameRunner = new GameRunner(game);

        gameRunner.run();
    }
}
