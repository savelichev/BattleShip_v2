package Game;

import java.util.Scanner;

/**
 * Created by savel_000 on 17.05.2016.
 */
public class Game {

    public Game() {

    }

    Human human = new Human();
    Computer computer = new Computer();

    public void startGame(){
        while (true){
            human.getFriendBattleField().printField();
            System.out.println();
            computer.getEnemyBattleField().printField();

            System.out.println(human.move());

            human.getFriendBattleField().printField();
            System.out.println();
            computer.getEnemyBattleField().printField();


        }
        }

}
