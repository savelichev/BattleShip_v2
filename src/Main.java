import Field.EnemyBattleField;
import Field.FriendBattleField;


public class Main {

    public static void main(String[] args) {
        FriendBattleField fr = new FriendBattleField();
        fr.printField();


        EnemyBattleField enemyBattleField = new EnemyBattleField();
        enemyBattleField.printField();
    }
}
