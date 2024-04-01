package rpgGame;

public class UnitOrc extends Unit{

	public UnitOrc() {
		super("오크", 200, 20, 20);
	}
	
	@Override
	public int skill(Unit target) {
		return 0;
	}
}
