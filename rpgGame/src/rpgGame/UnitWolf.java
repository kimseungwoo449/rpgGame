package rpgGame;

public class UnitWolf extends Unit{

	public UnitWolf() {
		super("늑대", 150, 20, 17);
	}
	
	@Override
	public int skill(Unit target) {
		return 0;
	}
}
