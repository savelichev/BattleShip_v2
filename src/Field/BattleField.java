package Field;

import java.util.ArrayList;

public abstract class BattleField {

    private char[][] field = new char[10][10];

    private ArrayList<Ship> ships;

    private ArrayList<Cell> usedCells = new ArrayList<>();

    private ArrayList<Cell> shots = new ArrayList<>();

    private ArrayList<Cell> missShots = new ArrayList<>();


    public ArrayList<Cell> getMissShots() {
        return missShots;
    }

    public ArrayList<Cell> getShots() {
        return shots;
    }

    public ArrayList<Cell> getUsedCells() {
        return usedCells;
    }

    public ArrayList<Ship> getShips() {
        return ships;
    }

    public void setShips(ArrayList<Ship> ships) {
        this.ships = ships;
    }


    public char[][] getField() {
        return field;
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

        shots.add(targetCell);

        for (Ship ship : ships) {
            for (Deck deck : ship.getAliveDecks()) {
                if (targetCell.equals(deck)) {
                    ship.hitDeck(deck);
                    if (ship.isDestroyedShip()) {
                        missShots.addAll(ship.getAroundCells());
                        return 2;
                    } else return 1;
                }
            }
        }
        missShots.add(targetCell);
        return 0;
    }

    public void drowBasicCellMarks() {
        usedCells = new ArrayList<>();

        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                field[i][j] = 'o';
            }
        }
    }

    public void markShipAsDestroyed(Ship ship) {
        for (Deck deck : ship.getHitDecks()) {
            markCellAsDestroyedDeck(deck);
        }

        for (Cell cell : ship.getAroundCells()) {
            markCellAsMiss(cell);
        }

    }


    public void markCellAsMiss(Cell cell) {
        field[(cell.getHorizontal())][(cell.getVertical())] = '*';
    }

    public void markCellAsHitDeck(Cell cell) {
        field[(cell.getHorizontal())][(cell.getVertical())] = 'x';
    }

    public void markCellAsDestroyedDeck(Cell cell) {
        field[(cell.getHorizontal())][(cell.getVertical())] = 'X';
    }

    public void markCellAsAliveDeck(Cell cell) {
        field[(cell.getHorizontal())][(cell.getVertical())] = 'H';
    }

    public void printField() {

        prepearField();

        System.out.println("\tA B C D E F G H I J");
        for (int i = 0; i < 10; i++) {
            printRowMarks(i);

            for (int j = 0; j < 10; j++) {
                System.out.print(getField()[i][j] + " ");
            }
            System.out.println();
        }
    }

    protected abstract void prepearField();

    ;


//    public void drowShipsForFriendField() {
//
//        for (Ship ship : ships) {
//            for (Deck deck : ship.getAliveDecks()) {
//                int x = deck.getHorizontal();
//                int y = deck.getVertical();
//                field[x][y] = 'H';
//            }
//        }
//        for (Ship ship : ships) {
//            for (Deck deck : ship.getHitDecks()) {
//                int x = deck.getHorizontal();
//                int y = deck.getVertical();
//                field[x][y] = '/';
//            }
//        }
//
//    }
}
