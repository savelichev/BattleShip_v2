package Game;

import Field.Deck;
import Field.Ship;

import java.util.Collections;

/**
 * Created by savel_000 on 17.05.2016.
 */
public class Game {

    public Game() {

    }

    Human human = new Human();
    Computer computer = new Computer();

    public void startGame() {

        Boolean isHumanMove = true;
        Boolean endGame = false;

        computer.getHumanBattleField().printField();
        System.out.println();
        human.getComputerBattleField().printField();


        while (!endGame) {

            if (isHumanMove) {
                String flag = human.move();
                if (flag == "hit" || flag == "destroy") {
                    isHumanMove = true;
                } else if (flag == "miss") {
                    isHumanMove = false;
                }
            } else {
                String flag = computer.move();
                if (flag == "hit" || flag == "destroy") {
                    isHumanMove = false;
                } else if (flag == "miss") {
                    isHumanMove = true;
                }
            }


            computer.getHumanBattleField().printField();
            System.out.println();
            human.getComputerBattleField().printField();
            if (winnerCheck()) {
                System.out.println("Game is over!");
                endGame = true;
            }
        }
    }

    public boolean winnerCheck() {

        for (Ship ship : human.getComputerBattleField().getShips()) {

            if ((ship.getAliveDecks().size() > 0)) {
                return false;
            }

        }

        for (Ship ship : computer.getHumanBattleField().getShips()) {

            if ((ship.getAliveDecks().size() > 0)) {
                return false;
            }

        }

        return true;
    }

}
