package Field;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Ship {

    public Ship(int deckCapacity) {
        this.deckCapacity = deckCapacity;
    }

    private ArrayList<Deck> decks = new ArrayList<>();
    private ArrayList<Deck> hitDecks;
    private ArrayList<Cell> aroundCells = new ArrayList();

    private int deckCapacity;

    public ArrayList<Deck> getDecks() {
        return decks;
    }

    public ArrayList<Deck> getHitDecks() {
        return hitDecks;
    }

    public ArrayList<Cell> getAroundCells() {
        return aroundCells;
    }

    public int getDeckCapacity() {
        return deckCapacity;
    }

    public boolean isDestroyedShip() {
        if (decks.size() == hitDecks.size()) {
            return true;
        }
        return false;
    }

    public void findAroundCells() {

        for (Deck deck : decks) {
            aroundCells.addAll(deck.findNearestCellsForOneCell());
        }
        filterCellFromDecks();

    }


    public void filterCellFromDecks() {

        Set<Cell> set = new HashSet<>(aroundCells);

        set.removeAll(decks);

        aroundCells = new ArrayList<>(set);

    }


}
