package Field;

public class ComputerBattleField extends BattleField {

    public ComputerBattleField() {
        setShips(new ShipFactory().createShips());
    }

    @Override
    protected void prepearField() {
        drowBasicCellMarks();

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


}


