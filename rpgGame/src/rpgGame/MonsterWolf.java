package rpgGame;

public class MonsterWolf extends Monster{

	public MonsterWolf( int maxHp, int offensivePower, int exp) {
		super("늑대", maxHp, offensivePower, exp);
	}

	@Override
	public int skill(Unit target) {
		return 0;
	}
}
