package Game;

import Field.Cell;

import java.util.Scanner;

public class Human extends Player {
    @Override
    public Cell move() {

        Scanner in = new Scanner(System.in);
        System.out.print("Enter vertical coordinate(it must be letter A-J): ");
        String vertical = in.nextLine();
        System.out.print("Enter horizontal coordinate(it must be digital): ");
        int horizontal = in.nextInt();
        System.out.println("Your shoot is: " + vertical + "," + horizontal);

        return convertHumanInputToCell(horizontal, vertical);
    }


    private Cell convertHumanInputToCell(int hor, String ver) {

        int horizontal = hor - 1;
        int vertical = 0;

        switch (ver) {
            case "A":
                vertical = 0;
                break;
            case "B":
                vertical = 1;
                break;
            case "C":
                vertical = 2;
                break;
            case "D":
                vertical = 3;
                break;
            case "E":
                vertical = 4;
                break;
            case "F":
                vertical = 5;
                break;
            case "G":
                vertical = 6;
                break;
            case "H":
                vertical = 7;
                break;
            case "I":
                vertical = 8;
                break;
            case "J":
                vertical = 9;
                break;
        }

        return new Cell(horizontal, vertical);
    }
}
