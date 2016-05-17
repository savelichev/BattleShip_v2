package Game;

import Field.Cell;
import Field.ComputerBattleField;
import Field.HumanBattleField;

import java.util.Random;


public class Computer extends Player {

    public HumanBattleField getHumanBattleField() {
        return humanBattleField;
    }

    HumanBattleField humanBattleField = new HumanBattleField();

    @Override
    public String move() {

        Random random = new Random();
        Cell targetCell;

        do {
            targetCell = new Cell(random.nextInt(10), random.nextInt(10));
        } while ((humanBattleField.getShots().contains(targetCell)));

        String answer = shoot(targetCell, humanBattleField);
        humanBattleField.getShots().add(targetCell);
        return answer;
    }

//    @Override
//    public Cell move() {
//        Random random =  new Random();
//
//        return new Cell(random.nextInt(10),random.nextInt(10));
//    }


}
