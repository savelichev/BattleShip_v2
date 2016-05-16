package Game;


import Field.*;


public abstract class Player {

    public abstract Cell move();

    public int shoot(Cell targetCell, BattleField field) {

        for (Ship ship : field.getShips()) {
            for (Deck deck: ship.getDecks()){
                if(targetCell.equals(deck)){

                }
            }
        }
        return 0;//!!!!!!!!!!!!!!!!!!!!!!!!!!
    }

}
