package rpgGame;

public class MonsterOrc extends Monster{

	
	public MonsterOrc( int maxHp, int offensivePower, int exp) {
		super("오크", maxHp, offensivePower, exp);
	}

	@Override
	public int skill(Unit target) {
		return 0;
	}
}
