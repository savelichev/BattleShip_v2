import Field.BattleField;
import Field.EnemyBattleField;
import Field.FriendBattleField;
import Field.ShipFactory;



public class Main {

    public static void main(String[] args) {



        ShipFactory SHF = new ShipFactory();
        FriendBattleField myBF = new FriendBattleField();
        myBF.setShips(SHF.createShips());

        myBF.printField();


        EnemyBattleField enemyBF = new EnemyBattleField();
        enemyBF.setShips(SHF.createShips());

        enemyBF.printField();
    }
}
