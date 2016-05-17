package Game;

/**
 * Created by savel_000 on 17.05.2016.
 */
public class Game {

    public Game() {

    }

    Human human = new Human();
    Computer computer = new Computer();

    public void startGame() {

        Boolean humanMove = true;
        Boolean endGame = false;
        while (!endGame) {
            human.getHumanBattleField().printField();
            System.out.println();
            computer.getComputerBattleField().printField();


        }
    }

}
