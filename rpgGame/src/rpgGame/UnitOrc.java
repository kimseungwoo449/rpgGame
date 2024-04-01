package rpgGame;

public class UnitOrc extends Unit{

	
	public UnitOrc( int maxHp, int offensivePower, int exp) {
		super("오크", maxHp, offensivePower, exp);
	}

	@Override
	public int skill(Unit target) {
		return 0;
	}
}
