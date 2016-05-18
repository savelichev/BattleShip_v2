package Field;

import java.util.ArrayList;
import java.util.regex.Pattern;


public class Cell {

    private int horizontal;

    private int vertical;

    public Cell(int horizontal, int vertical) {
        this.horizontal = horizontal;
        this.vertical = vertical;
    }

    public int getHorizontal() {
        return horizontal;
    }

    public int getVertical() {
        return vertical;
    }

    public ArrayList<Cell> findNearestCellsForOneCell() {

        ArrayList<Cell> nearestCells = new ArrayList<>();


        //top row
        nearestCells.add(new Cell(horizontal - 1, vertical - 1));
        nearestCells.add(new Cell(horizontal, vertical - 1));
        nearestCells.add(new Cell(horizontal + 1, vertical - 1));

        //left and right
        nearestCells.add(new Cell(horizontal - 1, vertical));
        nearestCells.add(new Cell(horizontal + 1, vertical));

        //bottom row
        nearestCells.add(new Cell(horizontal - 1, vertical + 1));
        nearestCells.add(new Cell(horizontal, vertical + 1));
        nearestCells.add(new Cell(horizontal + 1, vertical + 1));


        for (int i = 7; i >= 0; i--) {
            if (!(nearestCells.get(i).isCellOnField())) {
                nearestCells.remove(i);
            }
        }

        return nearestCells;
    }

    public boolean isCellOnField() {

        String horizontalPos = Integer.toString(horizontal);
        String verticalPos = Integer.toString(vertical);


        Pattern pattern = Pattern.compile("[0-9]");

        if ((horizontalPos.matches(String.valueOf(pattern)) && verticalPos.matches(String.valueOf(pattern)))) {
            return true;
        }


        return false;
    }

    @Override
    public String toString() {
        return horizontal +
                "," + vertical;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;

        Cell cell = (Cell) o;

        if (horizontal != cell.horizontal) return false;
        return vertical == cell.vertical;

    }

    @Override
    public int hashCode() {
        int result = horizontal;
        result = 31 * result + vertical;
        return result;
    }
}
