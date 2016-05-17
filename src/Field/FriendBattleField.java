package Field;

import java.util.ArrayList;


public class FriendBattleField extends BattleField {


    public FriendBattleField() {
        setShips(new ShipFactory().createShips());
    }


    protected void prepearField() {

        drowBasicCellMarks();

        for (Ship ship : getShips()) {
            for (Deck aliveDeck : ship.getAliveDecks()) {
                markCellAsAliveDeck(aliveDeck);
            }
        }

        for (Ship ship : getShips()) {
            for (Deck hitDeck : ship.getHitDecks()) {
                markCellAsHitDeck(hitDeck);
            }
        }

        for (Ship ship : getShips()) {
            for (Cell cell : getMissShots()) {
                markCellAsMiss(cell);
            }
        }

    }

    @Override
    public void printField() {

        prepearField();
        super.printField();

    }


}
