package Game;

import Field.Cell;
import Field.EnemyBattleField;

import java.util.Random;


public class Computer extends Player {

    EnemyBattleField enemyBattleField = new EnemyBattleField();

    public EnemyBattleField getEnemyBattleField() {
        return enemyBattleField;
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
