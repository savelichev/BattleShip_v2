package Game;

import Field.Cell;

import java.util.Random;

/**
 * Created by savel_000 on 17.05.2016.
 */
public class Computer extends Player {
    @Override
    public Cell move() {
        Random random =  new Random();

        return new Cell(random.nextInt(10),random.nextInt(10));
    }


}
