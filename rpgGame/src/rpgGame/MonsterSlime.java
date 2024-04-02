package rpgGame;

public class MonsterSlime extends Monster{


	public MonsterSlime( int maxHp, int offensivePower, int exp) {
		super("슬라임", maxHp, offensivePower, exp);
	}

	@Override
	public int skill(Unit target) {
		return 0;
	}
}
