package Game;

import Field.ComputerBattleField;


public class Computer extends Player {

    ComputerBattleField computerBattleField = new ComputerBattleField();

    public ComputerBattleField getComputerBattleField() {
        return computerBattleField;
    }

    @Override
    public String move() {
        return null;
    }

//    @Override
//    public Cell move() {
//        Random random =  new Random();
//
//        return new Cell(random.nextInt(10),random.nextInt(10));
//    }


}
