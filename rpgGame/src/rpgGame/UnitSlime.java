package rpgGame;

public class UnitSlime extends Unit{

	public UnitSlime() {
		super("슬라임", 120, 15, 10);
	}
	
	@Override
	public int skill(Unit target) {
		return 0;
	}
}
