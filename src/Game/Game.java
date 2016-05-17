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

        Boolean humanMove = false;
        Boolean endGame = false;
        while (!endGame) {
            computer.getHumanBattleField().printField();
            System.out.println();
            human.getComputerBattleField().printField();
            if (humanMove) {
                human.move();
            }else {
                computer.move();
            }


            computer.getHumanBattleField().printField();
            System.out.println();
            human.getComputerBattleField().printField();
        }
    }

}
