package Field;

import java.util.ArrayList;

public abstract class BattleField {

    private char[][] field = new char[10][10];

    private ArrayList<Ship> ships;

    private ArrayList<Cell> usedCells = new ArrayList<>();

    private ArrayList<Cell> shots = new ArrayList<>();

    public ArrayList<Ship> getShips() {
        return ships;
    }

    public void setShips(ArrayList<Ship> ships) {
        this.ships = ships;
    }

    {
        usedCells = new ArrayList<>();

        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                field[i][j] = 'o';
            }
        }
    }

    public char[][] getField() {
        return field;
    }

    public void drowShipsForFriendField() {

        for (Ship ship : ships) {
            for (Deck deck : ship.getAliveDecks()) {
                int x = deck.getHorizontal();
                int y = deck.getVertical();
                field[x][y] = 'H';
            }
        }
    }

    public void printField() {
        System.out.println("\tA B C D E F G H I J");
        for (int i = 0; i < 10; i++) {
            printRowMarks(i);

            for (int j = 0; j < 10; j++) {
                System.out.print(field[i][j] + " ");
            }
            System.out.println();
        }
    }


    public void printRowMarks(int i) {
        int row = i + 1;
        if (row != 10) {
            System.out.print(" " + row + "|\t");
        } else {
            System.out.print(row + "|\t");
        }
    }

    public int shoot(Cell targetCell) {

        for (Ship ship : ships) {
            for (Deck deck : ship.getAliveDecks()) {
                if (targetCell.equals(deck)) {
                    ship.hitDeck(deck);
                    if (ship.isDestroyedShip()) {
                        return 2;
                    } else return 1;
                }
            }
        }
        return 0;
    }

    public void markCellAsMiss(Cell cell) {
        field[(cell.getHorizontal())][(cell.getVertical())] = '*';
    }

    public void markCellAsHit(Cell cell) {
        field[(cell.getHorizontal())][(cell.getVertical())] = '/';
    }

    public void marCellAsDestroyed(Cell cell) {
        field[(cell.getHorizontal())][(cell.getVertical())] = 'X';
    }


}
