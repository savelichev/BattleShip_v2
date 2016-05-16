package Game;

import Field.Cell;

import java.util.Scanner;

/**
 * Created by savel_000 on 17.05.2016.
 */
public class Human extends Player {
    @Override
    public Cell move() {

        Scanner in = new Scanner(System.in);
        System.out.print("Enter vertical coordinate(it must be letter A-J): ");
        String vertical = in.nextLine();
        System.out.print("Enter horizontal coordinate(it must be digital): ");
        int horizontal = in.nextInt();
        System.out.println("Your shoot is: "+vertical+","+ horizontal);

        return null;
    }

    @Override
    public void shoot() {

    }
}
