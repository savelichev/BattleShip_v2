package Game;


import Field.*;


public abstract class Player {

    public abstract Cell move();

    public String shoot(Cell targetCell, BattleField field) {

        String result= "no shoot";
            switch (field.shoot(targetCell)){
                case 0 : result="miss"; break;
                case 1 : result="hit"; break;
                case 2 : result="destroy"; break;
            }

        return result;
    }

}
