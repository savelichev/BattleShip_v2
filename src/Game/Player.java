package Game;


import Field.*;


public abstract class Player {

    public abstract String move();

    public String shoot(Cell targetCell, BattleField field) {

        String result = "no shoot";
        int shot = field.shoot(targetCell);
        System.out.println(shot);
        switch (shot) {
            case 0:
                result = "miss";
                break;
            case 1:
                result = "hit";
                break;
            case 2:
                result = "destroy";
                break;
        }

        return result;
    }

}
