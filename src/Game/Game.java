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

        }
    }

}
