package Field;

import java.util.ArrayList;
import java.util.Random;

public class ShipFactory {

    private ArrayList<Cell> usedCells;

    private ArrayList<Ship> ships;

    private final int[] shipsAmountAndDecksCapacity = {0, 4, 3, 2, 1};

    public ArrayList<Ship> createShips() {

        usedCells = new ArrayList<>();
        ships = new ArrayList<>();

        for (int i = shipsAmountAndDecksCapacity.length - 1; i > 0; i--) {

            for (int j = 0; j < shipsAmountAndDecksCapacity[i]; j++) {

                Ship tempShip;

                do {
                    tempShip = createShip(i);

                    for (Deck deck : tempShip.getAliveDecks()) {

                    }

                } while (!validateShip(tempShip));

                ships.add(tempShip);
                usedCells.addAll(tempShip.getAliveDecks());
                usedCells.addAll(tempShip.getAroundCells());

            }

        }


        return ships;
    }

    private Ship createShip(int decks) {

        Ship ship = new Ship(decks);

        Random random = new Random();

        int orientation = random.nextInt(2);

        int horizontalFirstCoordinate;
        int verticalFirstCoordinate;


        if (orientation == 0) {
            //create horizontalShip

            verticalFirstCoordinate = random.nextInt(10);
            horizontalFirstCoordinate = random.nextInt(11 - decks);

            ship.getAliveDecks().add(new Deck(horizontalFirstCoordinate, verticalFirstCoordinate));

            for (int i = 1; i < decks; i++) {
                ship.getAliveDecks().add(new Deck(horizontalFirstCoordinate + i, verticalFirstCoordinate));
            }
        } else {
            //create verticalShip

            verticalFirstCoordinate = random.nextInt(11 - decks);
            horizontalFirstCoordinate = random.nextInt(10);

            ship.getAliveDecks().add(new Deck(horizontalFirstCoordinate, verticalFirstCoordinate));

            for (int i = 1; i < decks; i++) {
                ship.getAliveDecks().add(new Deck(horizontalFirstCoordinate, verticalFirstCoordinate + i));
            }
        }
        ship.findAroundCells();
        return ship;
    }

    private boolean validateShip(Ship tempShip) {

        for (Deck deck : tempShip.getAliveDecks()) {
            if (usedCells.contains((Cell) (deck))) {
                return false;
            }
        }

        return true;


    }
}
