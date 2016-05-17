package Field;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Ship {

    public Ship(int deckCapacity) {
        this.deckCapacity = deckCapacity;
    }

    private ArrayList<Deck> aliveDecks = new ArrayList<>();

    private ArrayList<Deck> hitDecks = new ArrayList<>();

    private ArrayList<Cell> aroundCells = new ArrayList();

    private int deckCapacity;


    public ArrayList<Deck> getAliveDecks() {
        return aliveDecks;
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
        if (aliveDecks.size()==0) {
            return true;
        }
        return false;
    }

    public void findAroundCells() {

        for (Deck deck : aliveDecks) {
            aroundCells.addAll(deck.findNearestCellsForOneCell());
        }
        filterCellFromDecks();

    }


    public void filterCellFromDecks() {

        Set<Cell> set = new HashSet<>(aroundCells);

        set.removeAll(aliveDecks);

        aroundCells = new ArrayList<>(set);

    }

    public void hitDeck(Deck deck) {
        if (aliveDecks.contains(deck)) {
            hitDecks.add(deck);
            aliveDecks.remove(deck);
        }
    }


}
